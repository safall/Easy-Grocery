package com.whitecatlabs.easygrocery

import app.cash.sqldelight.db.SqlDriver
import com.whitecatlabs.easygrocery.database.repository.GroceryRepository
import com.whitecatlabs.easygrocery.database.repository.GroceryRepositoryDefault
import com.whitecatlabs.easygrocery.screens.home.MainViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { MainViewModel(get()) }
}

val databaseModule = module {
    single<SqlDriver> { get<DatabaseDriverFactory>().createDriver() }
    single<EasyGroceryDatabase> { provideSqlDelightDatabase(get()) }
    single<GroceryRepository> { GroceryRepositoryDefault(get()) }
}

fun provideSqlDelightDatabase(driver: SqlDriver): EasyGroceryDatabase {
    return EasyGroceryDatabase(driver)
}

val allModules = listOf(appModule, databaseModule)
