package com.whitecatlabs.easygrocery.database

import com.whitecatlabs.easygrocery.database.entity.GroceryCategoryEntity
import com.whitecatlabs.easygrocery.database.entity.GroceryItemEntity
import com.whitecatlabs.easygrocery.database.entity.MasterGroceryEntity
import com.whitecatlabs.easygrocery.database.entity.MasterGroceryItemEntity

data class ItemWithSelected(
    val item: MasterGroceryItemEntity,
    val selectedItem: GroceryItemEntity?,
)

data class CategoryWithSelected(
    val selected: GroceryCategoryEntity,
    val item: MasterGroceryEntity,
)

data class MasterCategoryWithSelecte(
    val item: MasterGroceryEntity,
    val selectedItem: GroceryCategoryEntity?,
)
