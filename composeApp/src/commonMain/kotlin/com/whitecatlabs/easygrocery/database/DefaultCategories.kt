package com.whitecatlabs.easygrocery.database

import com.whitecatlabs.easygrocery.database.entity.GroceryCategoryEntity

object DefaultCategories {
    val presetCategoryItems = listOf(
        GroceryCategoryEntity(
            id = "1",
            isSelected = true,
        ),
        GroceryCategoryEntity(
            id = "3",
            isSelected = true,
        ),
        GroceryCategoryEntity(
            id = "4",
            isSelected = true,
        ),
    )
}
