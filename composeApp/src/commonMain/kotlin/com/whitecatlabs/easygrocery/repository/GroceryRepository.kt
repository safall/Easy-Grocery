package com.whitecatlabs.easygrocery.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

interface GroceryRepository {
    fun getCategory(): Flow<String>
}

class GroceryRepositoryDefault : GroceryRepository {
    override fun getCategory(): Flow<String> = flowOf("Vegetables")
}
