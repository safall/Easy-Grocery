package com.whitecatlabs.easygrocery

import com.whitecatlabs.easygrocery.di.allModules
import org.koin.core.context.startKoin

fun initKoin() {
    startKoin {
        modules(allModules)
    }
}
