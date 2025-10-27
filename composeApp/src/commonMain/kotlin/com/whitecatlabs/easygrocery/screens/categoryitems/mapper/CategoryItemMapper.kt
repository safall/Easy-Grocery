package com.whitecatlabs.easygrocery.screens.categoryitems.mapper

import com.whitecatlabs.easygrocery.database.ItemWithSelected
import com.whitecatlabs.easygrocery.screens.categoryitems.model.CategoryItemUiState

fun ItemWithSelected.toCategoryItemUiState(): CategoryItemUiState {
    return CategoryItemUiState(
        isSelected = selectedItem?.isSelected ?: false,
        title = item.title,
        groceryId = item.groceryId,
        itemId = item.id
    )
}
