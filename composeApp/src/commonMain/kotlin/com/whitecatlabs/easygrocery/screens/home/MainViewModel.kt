package com.whitecatlabs.easygrocery.screens.home

import androidx.lifecycle.viewModelScope
import com.whitecatlabs.easygrocery.BaseViewModel
import com.whitecatlabs.easygrocery.repository.GroceryRepository
import com.whitecatlabs.easygrocery.screens.home.MainContract.ViewState
import com.whitecatlabs.easygrocery.screens.home.MainContract.ViewState.Loading
import com.whitecatlabs.easygrocery.screens.home.model.CategoryUiState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.stateIn

class MainViewModel(
    private val repository: GroceryRepository,
) : BaseViewModel<ViewState, MainContract.Event>() {
    @OptIn(ExperimentalCoroutinesApi::class)
    override val uiState: StateFlow<ViewState> =
        getCategory()
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(),
                initialValue = Loading,
            )

    private fun getCategory(): Flow<ViewState> =
        flowOf(
            ViewState.Result(
                groceryCategories =
                    listOf(
                        CategoryUiState(id = "123", title = "Grocery", isSelected = true),
                        CategoryUiState(id = "124", title = "Cleaning Items", isSelected = false),
                        CategoryUiState(id = "125", title = "Fruits", isSelected = false),
                        CategoryUiState(id = "127", title = "Dairy Products", isSelected = false),
                    ),
                groceryCategoryItems = emptyList(),
            ),
        )

    override fun consumeEvent(event: MainContract.Event) = Unit

    data class CategoryItemUiState(
        val isSelected: Boolean,
        val title: String,
        val groceryId: String,
        val itemId: String,
    )
}
