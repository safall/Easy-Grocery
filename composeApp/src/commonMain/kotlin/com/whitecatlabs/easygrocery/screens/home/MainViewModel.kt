package com.whitecatlabs.easygrocery.screens.home

import androidx.lifecycle.viewModelScope
import com.whitecatlabs.easygrocery.BaseViewModel
import com.whitecatlabs.easygrocery.database.CategoryWithSelected
import com.whitecatlabs.easygrocery.database.ItemWithSelected
import com.whitecatlabs.easygrocery.screens.home.MainContract.ViewState
import com.whitecatlabs.easygrocery.screens.home.MainContract.ViewState.Loading
import com.whitecatlabs.easygrocery.screens.home.model.CategoryUiState
import com.whitecatlabs.easygrocery.screens.home.model.CategoryItemUiState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.stateIn
import com.whitecatlabs.easygrocery.database.repository.GroceryRepository
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: GroceryRepository
) : BaseViewModel<ViewState, MainContract.Event>() {
    var selectedIdFlow: MutableStateFlow<String> = MutableStateFlow("1")

    init {
        viewModelScope.launch {
            repository.populateDB()
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    override val uiState: StateFlow<ViewState> = getCategoryAndItems()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(),
            initialValue = Loading
        )

    override fun consumeEvent(event: MainContract.Event) {
        when (event) {
            is MainContract.Event.CategoryItemCheckedEvent -> viewModelScope.launch {
                selectedIdFlow.value = event.id
            }

            is MainContract.Event.ItemCheckedEvent -> viewModelScope.launch {
                repository.updateItemSelection(
                    event.groceryId,
                    event.id,
                    event.isSelected,
                )
            }

            else -> Unit

        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    private fun getCategoryAndItems(): Flow<ViewState> {
        return combine(
            selectedIdFlow, repository.getAllGroceryCategories()
        ) { selectedId, categories ->
            selectedId to categories
        }.flatMapLatest { (selectedId, categories) ->
            getCategoryItems(selectedId).map { categoryItems ->
                when {
                    categories.isEmpty() -> ViewState.Empty
                    else -> ViewState.Result(
                        groceryCategories = categories.map { it.toCategoryUiState(selectedId) },
                        groceryCategoryItems = categoryItems
                    )
                }
            }
        }
    }

    private fun getCategoryItems(id: String): Flow<List<CategoryItemUiState>> {
        return repository.getItemsWithSelection(id).map {
            it.map { item -> item.toCategoryItemUiState() }.filter { uiItem -> !uiItem.isSelected }
        }
    }

    fun ItemWithSelected.toCategoryItemUiState(): CategoryItemUiState {
        return CategoryItemUiState(
            isSelected = selectedItem?.isSelected == true,
            title = item.title,
            groceryId = item.groceryId,
            itemId = item.id,
        )
    }

    fun CategoryWithSelected.toCategoryUiState(selectedId: String): CategoryUiState {
        return CategoryUiState(
            id = item.id, title = item.title, isSelected = selectedId == item.id
        )
    }
}
