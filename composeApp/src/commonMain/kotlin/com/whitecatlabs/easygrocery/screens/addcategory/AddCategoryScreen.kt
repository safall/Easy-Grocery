package com.whitecatlabs.easygrocery.screens.addcategory

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.whitecatlabs.easygrocery.screens.addcategory.model.AddCategoryUiState
import com.whitecatlabs.easygrocery.resources.Res
import com.whitecatlabs.easygrocery.resources.error_message
import com.whitecatlabs.easygrocery.ui.ColorUtil.parseColor
import org.jetbrains.compose.resources.stringResource

@Composable
fun AddCategoryScreen(
    viewState: AddCategoryContract.ViewState,
    modifier: Modifier = Modifier,
    onEvent: (AddCategoryContract.Event) -> Unit,
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        when (viewState) {
            is AddCategoryContract.ViewState.Error -> Text(
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center,
                text = stringResource(Res.string.error_message),
                color = MaterialTheme.colorScheme.error,
            )

            is AddCategoryContract.ViewState.Loading -> CircularProgressIndicator(modifier = Modifier.size(40.dp))
            is AddCategoryContract.ViewState.Result -> Content(
                viewState.items,
                onEvent,
            )
        }
    }
}

@Composable
private fun Content(
    items: List<AddCategoryUiState>,
    onEvent: (AddCategoryContract.Event) -> Unit,
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            items.forEach {
                Grocery(item = it) { event ->
                    onEvent(event)
                }
            }
        }
    }
}

@Composable
fun Grocery(
    item: AddCategoryUiState,
    modifier: Modifier = Modifier,
    onEvent: (AddCategoryContract.Event) -> Unit,
) {
    Row(
        modifier = modifier
            .height(40.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Box(
            modifier = Modifier
                .size(30.dp)
                .clip(RoundedCornerShape(size = 8.dp)),
        ) {
            Box(
                modifier = Modifier
                    .size(30.dp)
                    .background(item.color.parseColor())
            )
        }
        Text(
            modifier = Modifier.weight(1f),
            fontWeight = FontWeight.Bold,
            text = item.title,
            textAlign = TextAlign.Start,
            fontSize = 16.sp,
        )

        Checkbox(
            enabled = (item.id != "1") && (item.id != "3") && (item.id != "4"),
            checked = item.isSelected,
            onCheckedChange = {
                onEvent(AddCategoryContract.Event.ItemCheckedEvent(id = item.id, isSelected = it))
            },
        )
    }
}

@Composable
private fun AddCategoryScreenPreview() {
    MaterialTheme {
        AddCategoryScreen(
            viewState = AddCategoryContract.ViewState.Result(
                listOf(
                    AddCategoryUiState("1", "Apple", color = "#0f0f0f0f", isSelected = true),
                    AddCategoryUiState("2", "Orange", color = "#0f0f0f0f", isSelected = true),
                ),
            ),
        ) {}
    }
}
