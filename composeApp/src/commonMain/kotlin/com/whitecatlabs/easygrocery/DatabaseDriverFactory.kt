package com.whitecatlabs.easygrocery

import app.cash.sqldelight.db.SqlDriver
expect class DatabaseDriverFactory {
    fun createDriver(): SqlDriver
}