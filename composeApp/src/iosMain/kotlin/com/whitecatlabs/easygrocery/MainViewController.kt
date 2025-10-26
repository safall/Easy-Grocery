package com.whitecatlabs.easygrocery

import androidx.compose.ui.window.ComposeUIViewController
import org.koin.core.context.startKoin

fun MainViewController() =
    ComposeUIViewController(
        configure = {
            initKoin()
        },
    ) { App() }

fun initKoin() {
    startKoin {
        modules(allModules + platformModule())
    }
}