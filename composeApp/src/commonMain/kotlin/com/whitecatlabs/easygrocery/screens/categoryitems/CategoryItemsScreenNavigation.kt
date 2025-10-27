package com.whitecatlabs.easygrocery.screens.categoryitems

import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.parametersOf

@Serializable
data class CategoryItemsScreenNavigation(val id: String, val title: String)

fun NavGraphBuilder.categoryItems(navigateUp: () -> Unit, title: (String) -> Unit) {
    composable<CategoryItemsScreenNavigation> {
        val arguments = it.toRoute<CategoryItemsScreenNavigation>()
        val viewModel: ItemsViewModel = koinViewModel { parametersOf(arguments.id) }
        title(arguments.title)
        val viewState = viewModel.uiState.collectAsStateWithLifecycle().value
        ItemsScreen(viewState = viewState) { event ->
            when (event) {
                is ItemsContract.Event.BackButtonClickedEvent -> navigateUp()
                is ItemsContract.Event.ItemClickedEvent -> Unit
                is ItemsContract.Event.ItemCheckedEvent -> viewModel.consumeEvent(event)
            }
        }
    }
}

fun NavController.navigateToCategoryItems(id: String, title: String) {
    navigate(CategoryItemsScreenNavigation(id, title))
}
