package com.whitecatlabs.easygrocery.screens.settings

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data object SettingsScreenNavigation

@Suppress("UnusedPrivateProperty")
fun NavGraphBuilder.settings(
    navigateToContactUs: () -> Unit,
    navigateToPrivacyPolicy: () -> Unit,
    title: (String) -> Unit,
) {
    composable<SettingsScreenNavigation> {
        title("Settings")
        SettingsScreen(
            navigateToContactUs = navigateToContactUs,
            navigateToPrivacyPolicyPage = navigateToPrivacyPolicy,
        )
    }
}
