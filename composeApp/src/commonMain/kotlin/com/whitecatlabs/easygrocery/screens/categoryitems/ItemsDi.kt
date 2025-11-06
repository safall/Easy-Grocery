package com.whitecatlabs.easygrocery.screens.categoryitems

import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val itemsDi =
    module {
        viewModel { (categoryId: String) -> ItemsViewModel(categoryId, get()) }
    }
