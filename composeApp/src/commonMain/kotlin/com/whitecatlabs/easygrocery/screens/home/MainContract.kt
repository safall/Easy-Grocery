package com.whitecatlabs.easygrocery.screens.home

import com.whitecatlabs.easygrocery.screens.home.MainViewModel.CategoryItemUiState
import com.whitecatlabs.easygrocery.screens.home.model.CategoryUiState

class MainContract {
    sealed class ViewState {
        data object Empty : ViewState()

        data class Result(
            val groceryCategories: List<CategoryUiState>,
            val groceryCategoryItems: List<CategoryItemUiState>,
        ) : ViewState()

        data object Loading : ViewState()

        data object Error : ViewState()
    }

    sealed interface Event {
        data object AddButtonClickedEvent : Event

        data object BackButtonClickedEvent : Event

        data class CategoryItemCheckedEvent(
            val id: String,
            val title: String,
            val isSelected: Boolean,
        ) : Event

        data class ItemCheckedEvent(
            val id: String,
            val groceryId: String,
            val title: String,
            val isSelected: Boolean,
        ) : Event
    }
}
