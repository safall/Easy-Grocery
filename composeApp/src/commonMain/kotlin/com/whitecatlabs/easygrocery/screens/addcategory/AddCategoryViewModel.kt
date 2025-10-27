package com.whitecatlabs.easygrocery.screens.addcategory

import androidx.lifecycle.viewModelScope
import com.whitecatlabs.easygrocery.BaseViewModel
import com.whitecatlabs.easygrocery.database.entity.GroceryCategoryEntity
import com.whitecatlabs.easygrocery.database.repository.GroceryRepository
import com.whitecatlabs.easygrocery.screens.addcategory.AddCategoryContract.ViewState
import com.whitecatlabs.easygrocery.screens.addcategory.AddCategoryContract.ViewState.Loading
import com.whitecatlabs.easygrocery.screens.addcategory.mapper.toUiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class AddCategoryViewModel(
    private val repository: GroceryRepository,
) : BaseViewModel<ViewState, AddCategoryContract.Event>() {

    override val uiState: StateFlow<ViewState> = getAllCategories()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(),
            initialValue = Loading,
        )

    @Suppress("TooGenericExceptionCaught")
    private fun getAllCategories(): Flow<ViewState> {
        return try {
            repository.getAllMasterCategories()
                .map { result ->
                    ViewState.Result(result.map { it.toUiState() })
                }
        } catch (e: Exception) {
            e.printStackTrace()
            flow { ViewState.Error }
        }
    }

    override fun consumeEvent(event: AddCategoryContract.Event) {
        when (event) {
            is AddCategoryContract.Event.BackButtonClickedEvent -> Unit
            is AddCategoryContract.Event.ItemCheckedEvent -> {
                val viewState = uiState.value as? ViewState.Result ?: return
                val item = viewState.items.find { it.id == event.id } ?: return
                viewModelScope.launch {
                    repository.insertGroceryCategories(
                        listOf(
                            GroceryCategoryEntity(
                                id = item.id,
                                isSelected = event.isSelected
                            )
                        )
                    )
                }
            }
        }
    }
}
