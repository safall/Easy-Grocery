package com.whitecatlabs.easygrocery.di

import com.whitecatlabs.easygrocery.repository.GroceryRepository
import com.whitecatlabs.easygrocery.repository.GroceryRepositoryDefault
import com.whitecatlabs.easygrocery.screens.home.MainViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule =
    module {
        // Repositories
        single<GroceryRepository> { GroceryRepositoryDefault() }

        viewModel { MainViewModel(get()) }
    }

// Combine all modules
val allModules = listOf(appModule)
