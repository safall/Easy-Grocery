package com.whitecatlabs.easygrocery.screens.home

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
val mainDi = module {
    viewModelOf(::MainViewModel)
}
