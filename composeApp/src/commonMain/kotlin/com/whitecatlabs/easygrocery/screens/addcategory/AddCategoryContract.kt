package com.whitecatlabs.easygrocery.screens.addcategory

import com.whitecatlabs.easygrocery.screens.addcategory.model.AddCategoryUiState

interface AddCategoryContract {
    sealed interface Event {
        data object BackButtonClickedEvent : Event

        data class ItemCheckedEvent(
            val id: String,
            val isSelected: Boolean,
        ) : Event
    }

    sealed class ViewState {
        data class Result(
            val items: List<AddCategoryUiState>,
        ) : ViewState()

        data object Loading : ViewState()

        data object Error : ViewState()
    }
}
