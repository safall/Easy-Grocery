package com.whitecatlabs.easygrocery.database.entity

data class GroceryItemEntity(
    val id: String,
    val groceryId: String,
    val lastPurchasePrice: String,
    val isSelected: Boolean,
)
