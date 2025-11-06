package com.whitecatlabs.easygrocery

import org.koin.core.module.Module
import org.koin.dsl.module

actual fun platformModule(): Module =
    module {
        single<DatabaseDriverFactory> { DatabaseDriverFactory() }
    }
