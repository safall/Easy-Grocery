package com.whitecatlabs.easygrocery.database

import com.whitecatlabs.easygrocery.FetchAllSelected
import com.whitecatlabs.easygrocery.FetchAllWithSelection
import com.whitecatlabs.easygrocery.FetchItemsWithSelected
import com.whitecatlabs.easygrocery.database.entity.GroceryCategoryEntity
import com.whitecatlabs.easygrocery.database.entity.GroceryItemEntity
import com.whitecatlabs.easygrocery.database.entity.MasterGroceryEntity
import com.whitecatlabs.easygrocery.database.entity.MasterGroceryItemEntity

fun FetchAllWithSelection.toMasterCategoryWithSelecte(): MasterCategoryWithSelecte {
    return MasterCategoryWithSelecte(
        item = MasterGroceryEntity(
            id = mg_id,
            title = mg_title,
            color = mg_color
        ),
        selectedItem = if (gc_id != null) {
            GroceryCategoryEntity(
                id = gc_id,
                isSelected = gc_isSelected ?: false
            )
        } else {
            null
        }
    )
}

// Map SQLDelight result to CategoryWithSelected
fun FetchAllSelected.toCategoryWithSelected(): CategoryWithSelected {
    return CategoryWithSelected(
        selected = GroceryCategoryEntity(
            id = gc_id,
            isSelected = gc_isSelected
        ),
        item = MasterGroceryEntity(
            id = mg_id,
            title = mg_title,
            color = mg_color
        )
    )
}

// Map SQLDelight result to ItemWithSelected
fun FetchItemsWithSelected.toItemWithSelected(): ItemWithSelected {
    return ItemWithSelected(
        item = MasterGroceryItemEntity(
            id = mgi_id,
            groceryId = mgi_groceryId,
            title = mgi_title
        ),
        selectedItem = if (gi_id != null) {
            GroceryItemEntity(
                id = gi_id,
                groceryId = gi_groceryId ?: "",
                lastPurchasePrice = gi_lastPurchasePrice ?: "",
                isSelected = gi_isSelected ?: false
            )
        } else {
            null
        }
    )
}
