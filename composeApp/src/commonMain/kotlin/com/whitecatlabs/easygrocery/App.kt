package com.whitecatlabs.easygrocery

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.whitecatlabs.easygrocery.screens.home.MainScreenNavigation
import com.whitecatlabs.easygrocery.screens.home.main

@Composable
fun App() {
    MaterialTheme {
        GroceryApp()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Suppress("LongMethod")
@Composable
private fun GroceryApp(navController: NavHostController = rememberNavController()) {
    val navBackStackEntry = navController.currentBackStackEntryAsState().value
    val currentDestination = navBackStackEntry?.destination
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Easy Grocery",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                    )
                },
                navigationIcon = {
                    if (currentDestination.shouldShowBackButton()) {
                        IconButton(onClick = { navController.navigateUp() }) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Back",
                            )
                        }
                    }
                },
            )
        },
    ) { innerPadding ->
        NavHost(
            modifier = Modifier.padding(innerPadding),
            navController = navController,
            startDestination = MainScreenNavigation,
        ) {
            main(
                title = { "Main" },
                navigateToAddCategory = { },
                updateSelectedCategory = { id, title -> },
                navigateBack = { navController.navigateUp() },
            )
        }
    }
}

@Suppress("TrailingCommaOnDeclarationSite", "internal:trailing-comma-on-declaration-site")
private fun NavDestination?.shouldShowBackButton(): Boolean =
    when (this?.route) {
        MainScreenNavigation::class.qualifiedName -> false
        else -> true
    }
