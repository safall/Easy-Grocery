package com.whitecatlabs.easygrocery.screens.categoryitems

import androidx.lifecycle.viewModelScope
import com.whitecatlabs.easygrocery.BaseViewModel
import com.whitecatlabs.easygrocery.database.repository.GroceryRepository
import com.whitecatlabs.easygrocery.screens.categoryitems.ItemsContract.ViewState
import com.whitecatlabs.easygrocery.screens.categoryitems.ItemsContract.ViewState.Loading
import com.whitecatlabs.easygrocery.screens.categoryitems.mapper.toCategoryItemUiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ItemsViewModel(
    id: String,
    private val repository: GroceryRepository,
) : BaseViewModel<ViewState, ItemsContract.Event>() {

    override val uiState: StateFlow<ViewState> = getAllItems(id).stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(),
        initialValue = Loading,
    )

    @Suppress("TooGenericExceptionCaught")
    private fun getAllItems(id: String): Flow<ViewState> {
        return try {
            repository.getItemsWithSelection(id).map { items ->
                ViewState.Result(items.map { it.toCategoryItemUiState() })
            }
        } catch (e: Exception) {
            e.printStackTrace()
            flow { ViewState.Error }
        }
    }

    override fun consumeEvent(event: ItemsContract.Event) {
        when (event) {
            is ItemsContract.Event.ItemCheckedEvent -> viewModelScope.launch {
                repository.updateItemSelection(
                    event.groceryId,
                    event.id,
                    event.isChecked,
                )
            }

            else -> Unit
        }
    }
}
