package com.whitecatlabs.easygrocery

import org.koin.dsl.module
import org.koin.core.module.Module
actual fun platformModule(): Module = module {
    single<DatabaseDriverFactory> { DatabaseDriverFactory() }
}