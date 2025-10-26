package com.whitecatlabs.easygrocery

import org.koin.dsl.module
import org.koin.core.module.Module
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(EasyGroceryDatabase.Schema, "mydatabase.db")
    }
}
