package com.whitecatlabs.easygrocery.screens.addcategory.mapper

import com.whitecatlabs.easygrocery.database.MasterCategoryWithSelecte
import com.whitecatlabs.easygrocery.screens.addcategory.model.AddCategoryUiState

fun MasterCategoryWithSelecte.toUiState(): AddCategoryUiState =
    AddCategoryUiState(
        id = item.id,
        title = item.title,
        color = item.color,
        isSelected = selectedItem?.isSelected ?: false,
    )
