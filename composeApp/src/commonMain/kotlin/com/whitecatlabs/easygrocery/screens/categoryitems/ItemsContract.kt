package com.whitecatlabs.easygrocery.screens.categoryitems

import com.whitecatlabs.easygrocery.screens.categoryitems.model.CategoryItemUiState

class ItemsContract {
    sealed class ViewState {
        data class Result(
            val items: List<CategoryItemUiState>,
        ) : ViewState()

        data object Loading : ViewState()

        data object Error : ViewState()
    }

    sealed interface Event {
        data object BackButtonClickedEvent : Event

        data class ItemClickedEvent(
            val id: String,
        ) : Event

        data class ItemCheckedEvent(
            val groceryId: String,
            val id: String,
            val isChecked: Boolean,
        ) : Event
    }
}
