package com.whitecatlabs.easygrocery.screens.addcategory

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val addCategoryDi = module {
    viewModelOf(::AddCategoryViewModel)
}
