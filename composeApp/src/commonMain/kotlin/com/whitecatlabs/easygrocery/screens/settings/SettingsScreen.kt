package com.whitecatlabs.easygrocery.screens.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.whitecatlabs.easygrocery.resources.Res
import com.whitecatlabs.easygrocery.resources.contact_us
import com.whitecatlabs.easygrocery.resources.privacy_policy
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun SettingsScreen(
    navigateToContactUs: () -> Unit,
    navigateToPrivacyPolicyPage: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(modifier = modifier.fillMaxSize()) {
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            SettingsItem(
                textResId = Res.string.privacy_policy,
                onClick = { navigateToPrivacyPolicyPage() },
            )
            SettingsItem(
                textResId = Res.string.contact_us,
                onClick = { navigateToContactUs() },
            )
        }
    }
}

@Composable
fun SettingsItem(
    textResId: StringResource,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) {
    TextButton(
        modifier = modifier,
        onClick = onClick,
        enabled = enabled,
        colors =
            ButtonDefaults.textButtonColors(
                contentColor = MaterialTheme.colorScheme.onBackground,
            ),
        content = {
            Text(
                modifier = Modifier.weight(1f),
                text = stringResource(textResId),
                textAlign = TextAlign.Start,
            )
        },
    )
}

@Composable
private fun SettingsPreview() {
    MaterialTheme {
        Scaffold { innerPadding ->
            SettingsScreen(
                navigateToContactUs = {},
                navigateToPrivacyPolicyPage = {},
                modifier = Modifier.consumeWindowInsets(innerPadding),
            )
        }
    }
}
