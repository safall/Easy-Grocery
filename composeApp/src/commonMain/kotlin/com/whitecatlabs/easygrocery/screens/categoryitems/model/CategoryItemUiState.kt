package com.whitecatlabs.easygrocery.screens.categoryitems.model

data class CategoryItemUiState(
    val isSelected: Boolean,
    val title: String,
    val groceryId: String,
    val itemId: String,
)
