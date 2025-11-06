package com.whitecatlabs.easygrocery.screens.home

import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.koin.compose.viewmodel.koinViewModel

@Serializable
data object MainScreenNavigation

fun NavGraphBuilder.main(
    navigateToAddCategory: () -> Unit,
    updateSelectedCategory: (String, String) -> Unit,
    navigateBack: () -> Unit,
) {
    composable<MainScreenNavigation> {
        val viewModel: MainViewModel = koinViewModel()
        val viewState = viewModel.uiState.collectAsStateWithLifecycle().value
        MainScreen(viewState = viewState) { event ->
            when (event) {
                is MainContract.Event.AddButtonClickedEvent -> navigateToAddCategory()
                is MainContract.Event.BackButtonClickedEvent -> navigateBack()
                is MainContract.Event.CategoryItemCheckedEvent -> {
                    updateSelectedCategory(event.id, event.title)
                    viewModel.consumeEvent(event)
                }

                is MainContract.Event.ItemCheckedEvent -> viewModel.consumeEvent(event)
            }
        }
    }
}

fun NavController.navigateToMain() {
    navigate(MainScreenNavigation)
}
