package com.whitecatlabs.easygrocery.screens.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.whitecatlabs.easygrocery.resources.Res
import com.whitecatlabs.easygrocery.resources.empty_category_item_message
import com.whitecatlabs.easygrocery.resources.error_message
import com.whitecatlabs.easygrocery.screens.home.MainContract.Event
import com.whitecatlabs.easygrocery.screens.home.MainContract.ViewState
import com.whitecatlabs.easygrocery.screens.home.model.CategoryItemUiState
import com.whitecatlabs.easygrocery.screens.home.model.CategoryUiState
import com.whitecatlabs.easygrocery.ui.CategoryItemRow
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun MainScreen(
    viewState: ViewState,
    modifier: Modifier = Modifier,
    onEvent: (Event) -> Unit,
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        when (viewState) {
            is ViewState.Empty -> EmptyState()
            is ViewState.Error ->
                Text(
                    style = MaterialTheme.typography.bodyLarge,
                    textAlign = TextAlign.Center,
                    text = stringResource(Res.string.error_message),
                    color = MaterialTheme.colorScheme.error,
                )

            is ViewState.Loading -> CircularProgressIndicator(modifier = Modifier.size(40.dp))
            is ViewState.Result ->
                Content(
                    viewState.groceryCategories,
                    viewState.groceryCategoryItems,
                    onEvent,
                )
        }
    }
}

@Composable
private fun EmptyState(
    modifier: Modifier = Modifier,
    textResId: StringResource = Res.string.empty_category_item_message,
) {
    Text(
        modifier =
            modifier
                .fillMaxWidth()
                .padding(16.dp),
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold,
        text = stringResource(textResId),
    )
}

@Composable
private fun Content(
    categoryItems: List<CategoryUiState>,
    items: List<CategoryItemUiState>,
    onEvent: (Event) -> Unit,
) {
    Column(modifier = Modifier.fillMaxSize()) {
        CategoryRowItems(categoryItems, onEvent)
        if (items.isNotEmpty()) {
            Items(items, onEvent)
        } else {
            EmptyState()
        }
    }
}

@Composable
private fun CategoryRowItems(
    items: List<CategoryUiState>,
    onEvent: (Event) -> Unit,
) {
    LazyRow(
        modifier = Modifier.padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(
            count = items.size,
            key = { items[it].id },
        ) { index ->
            val item = items[index]
            FilterChip(
                selected = item.isSelected,
                label = { Text(text = item.title) },
                onClick = {
                    onEvent(
                        Event.CategoryItemCheckedEvent(
                            id = item.id,
                            title = item.title,
                            isSelected = true,
                        ),
                    )
                },
            )
        }
    }
}

@Composable
private fun Items(
    items: List<CategoryItemUiState>,
    onEvent: (Event) -> Unit,
) {
    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(
            count = items.size,
            key = { items[it].itemId },
        ) { index ->
            val item = items[index]
            AnimatedVisibility(
                visible = !item.isSelected,
                exit = fadeOut() + shrinkVertically(),
            ) {
                CategoryItemRow(
                    isSelected = item.isSelected,
                    title = item.title,
                    onCheckChanged = {
                        onEvent(
                            Event.ItemCheckedEvent(
                                id = item.itemId,
                                groceryId = item.groceryId,
                                title = item.title,
                                isSelected = it,
                            ),
                        )
                    },
                )
            }
        }
    }
}

@Preview
@Composable
private fun MainPagePreview() {
    MaterialTheme {
        MainScreen(
            viewState =
                ViewState.Result(
                    groceryCategories =
                        listOf(
                            CategoryUiState(id = "123", title = "Grocery", isSelected = true),
                            CategoryUiState(id = "124", title = "Cleaning Items", isSelected = false),
                            CategoryUiState(id = "125", title = "Fruits", isSelected = false),
                            CategoryUiState(id = "127", title = "Dairy Products", isSelected = false),
                        ),
                    groceryCategoryItems =
                        listOf(
                            CategoryItemUiState(
                                isSelected = true,
                                title = "123",
                                groceryId = "123q351",
                                itemId = "124315",
                            ),
                        ),
                ),
        ) {}
    }
}
