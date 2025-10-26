package com.whitecatlabs.easygrocery.database.repository

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import com.whitecatlabs.easygrocery.EasyGroceryDatabase
import com.whitecatlabs.easygrocery.database.MasterTableData
import com.whitecatlabs.easygrocery.database.entity.GroceryCategoryEntity
import com.whitecatlabs.easygrocery.database.entity.MasterGroceryEntity
import com.whitecatlabs.easygrocery.database.entity.MasterGroceryItemEntity
import com.whitecatlabs.easygrocery.database.toCategoryWithSelected
import com.whitecatlabs.easygrocery.database.toItemWithSelected
import com.whitecatlabs.easygrocery.database.toMasterCategoryWithSelecte
import com.whitecatlabs.easygrocery.database.CategoryWithSelected
import com.whitecatlabs.easygrocery.database.DefaultCategories
import com.whitecatlabs.easygrocery.database.ItemWithSelected
import com.whitecatlabs.easygrocery.database.MasterCategoryWithSelecte
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

interface GroceryRepository {

    suspend fun populateDB()
    suspend fun insertMasterGrocery(items: List<MasterGroceryEntity>)
    suspend fun insertMasterGroceryItem(items: List<MasterGroceryItemEntity>)
    suspend fun insertGroceryCategories(items: List<GroceryCategoryEntity>)
    fun getAllMasterCategories(): Flow<List<MasterCategoryWithSelecte>>
    fun getAllGroceryCategories(): Flow<List<CategoryWithSelected>>
    fun getItemsWithSelection(id: String): Flow<List<ItemWithSelected>>
    suspend fun updateItemSelection(groceryId: String, id: String, isSelected: Boolean)
}

internal class GroceryRepositoryDefault(
    private val database: EasyGroceryDatabase,
) : GroceryRepository {
    override suspend fun populateDB() {
        withContext(Dispatchers.IO) {
            insertMasterGrocery(MasterTableData.groceries)
            insertMasterGroceryItem(MasterTableData.groceryItems)
            insertGroceryCategories(DefaultCategories.presetCategoryItems)
        }
    }


    override suspend fun insertMasterGrocery(items: List<MasterGroceryEntity>) {
        withContext(Dispatchers.IO) {
            database.transaction {
                items.forEach { item ->
                    database.masterGroceryQueries.insert(
                        id = item.id,
                        title = item.title,
                        color = item.color,
                    )
                }
            }
        }
    }

    override suspend fun insertMasterGroceryItem(items: List<MasterGroceryItemEntity>) {
        withContext(Dispatchers.IO) {
            database.transaction {
                items.forEach { item ->
                    database.masterGroceryItemQueries.insert(
                        id = item.id,
                        groceryId = item.groceryId,
                        title = item.title,
                    )
                }
            }
        }
    }

    override suspend fun insertGroceryCategories(items: List<GroceryCategoryEntity>) {
        withContext(Dispatchers.IO) {
            database.transaction {
                items.forEach { item ->
                    database.groceryCategoryQueries.insert(
                        id = item.id,
                        isSelected = item.isSelected,
                    )
                }
            }
        }
    }

    override fun getAllMasterCategories(): Flow<List<MasterCategoryWithSelecte>> {
        return database.masterGroceryQueries
            .fetchAllWithSelection()
            .asFlow()
            .mapToList(Dispatchers.IO)
            .map { list -> list.map { it.toMasterCategoryWithSelecte() } }
            .flowOn(Dispatchers.IO)
    }

    override fun getAllGroceryCategories(): Flow<List<CategoryWithSelected>> {
        return database.groceryCategoryQueries
            .fetchAllSelected()
            .asFlow()
            .mapToList(Dispatchers.IO)
            .map { list -> list.map { it.toCategoryWithSelected() } }
            .flowOn(Dispatchers.IO)
    }

    override fun getItemsWithSelection(id: String): Flow<List<ItemWithSelected>> {
        return database.groceryItemQueries
            .fetchItemsWithSelected(id)
            .asFlow()
            .mapToList(Dispatchers.IO)
            .map { list -> list.map { it.toItemWithSelected() } }
            .flowOn(Dispatchers.IO)
    }

    override suspend fun updateItemSelection(
        groceryId: String,
        id: String,
        isSelected: Boolean,
    ) {
        withContext(Dispatchers.IO) {
            database.groceryItemQueries.insert(
                id = id,
                groceryId = groceryId,
                lastPurchasePrice = "",
                isSelected = isSelected,
            )
        }
    }
}
