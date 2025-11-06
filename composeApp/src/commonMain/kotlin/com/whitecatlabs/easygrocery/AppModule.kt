package com.whitecatlabs.easygrocery

import app.cash.sqldelight.db.SqlDriver
import com.whitecatlabs.easygrocery.database.repository.GroceryRepository
import com.whitecatlabs.easygrocery.database.repository.GroceryRepositoryDefault
import com.whitecatlabs.easygrocery.screens.addcategory.AddCategoryViewModel
import com.whitecatlabs.easygrocery.screens.categoryitems.ItemsViewModel
import com.whitecatlabs.easygrocery.screens.home.MainViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule =
    module {
        viewModel { ActivityViewModel() }
        viewModel { MainViewModel(get()) }
        viewModel { AddCategoryViewModel(get()) }
        viewModel { ItemsViewModel(get(), get()) }
    }

val databaseModule =
    module {
        single<SqlDriver> { get<DatabaseDriverFactory>().createDriver() }
        single<EasyGroceryDatabase> { provideSqlDelightDatabase(get()) }
        single<GroceryRepository> { GroceryRepositoryDefault(get()) }
    }

fun provideSqlDelightDatabase(driver: SqlDriver): EasyGroceryDatabase = EasyGroceryDatabase(driver)

val allModules = listOf(appModule, databaseModule)
