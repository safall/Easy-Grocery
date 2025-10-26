package com.whitecatlabs.easygrocery.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CategoryItemRow(
    isSelected: Boolean,
    title: String,
    modifier: Modifier = Modifier,
    onCheckChanged: (Boolean) -> Unit,
) {
    Row(
        modifier =
            modifier
                .fillMaxWidth()
                .height(40.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Checkbox(
            checked = isSelected,
            onCheckedChange = { onCheckChanged(it) },
        )
        Text(
            fontWeight = FontWeight.Bold,
            text = title,
            textAlign = TextAlign.Start,
            fontSize = 16.sp,
        )
    }
}
