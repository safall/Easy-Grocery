package com.whitecatlabs.easygrocery.screens.categoryitems

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.whitecatlabs.easygrocery.resources.Res
import com.whitecatlabs.easygrocery.resources.error_message
import com.whitecatlabs.easygrocery.screens.categoryitems.model.CategoryItemUiState
import com.whitecatlabs.easygrocery.ui.CategoryItemRow
import org.jetbrains.compose.resources.stringResource

@Composable
fun ItemsScreen(
    viewState: ItemsContract.ViewState,
    modifier: Modifier = Modifier,
    onEvent: (ItemsContract.Event) -> Unit,
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        when (viewState) {
            is ItemsContract.ViewState.Error -> {
                Text(
                    style = MaterialTheme.typography.bodyLarge,
                    textAlign = TextAlign.Center,
                    text = stringResource(Res.string.error_message),
                    color = MaterialTheme.colorScheme.error,
                )
            }
            is ItemsContract.ViewState.Loading -> CircularProgressIndicator(modifier = Modifier.size(40.dp))
            is ItemsContract.ViewState.Result -> Content(
                items = viewState.items,
                onEvent = onEvent,
            )
        }
    }
}

@Composable
private fun Content(
    items: List<CategoryItemUiState>,
    modifier: Modifier = Modifier,
    onEvent: (ItemsContract.Event) -> Unit,
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(
            count = items.size,
            key = { items[it].itemId },
        ) { index ->
            val item = items[index]
            CategoryItemRow(
                isSelected = item.isSelected,
                title = item.title,
                onCheckChanged = {
                    onEvent(
                        ItemsContract.Event.ItemCheckedEvent(
                            item.groceryId,
                            item.itemId,
                            it,
                        ),
                    )
                },
            )
        }
    }
}
