package com.whitecatlabs.easygrocery.screens.addcategory

import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.koin.compose.viewmodel.koinViewModel

@Serializable
data object AddCategoryScreenNavigation

fun NavGraphBuilder.addCategory(navigateUp: () -> Unit) {
    composable<AddCategoryScreenNavigation> {
        val viewModel = koinViewModel<AddCategoryViewModel>()
        val viewState = viewModel.uiState.collectAsStateWithLifecycle().value
        AddCategoryScreen(viewState) { event ->
            when (event) {
                is AddCategoryContract.Event.BackButtonClickedEvent -> navigateUp()
                is AddCategoryContract.Event.ItemCheckedEvent -> viewModel.consumeEvent(event)
            }
        }
    }
}

fun NavHostController.navigateToAddCategory() = navigate(AddCategoryScreenNavigation)
