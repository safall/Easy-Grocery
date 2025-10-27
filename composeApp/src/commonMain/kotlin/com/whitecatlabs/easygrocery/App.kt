package com.whitecatlabs.easygrocery

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.whitecatlabs.easygrocery.screens.addcategory.AddCategoryScreenNavigation
import com.whitecatlabs.easygrocery.screens.addcategory.addCategory
import com.whitecatlabs.easygrocery.screens.categoryitems.categoryItems
import com.whitecatlabs.easygrocery.screens.categoryitems.navigateToCategoryItems
import com.whitecatlabs.easygrocery.screens.home.MainScreenNavigation
import com.whitecatlabs.easygrocery.screens.home.main
import com.whitecatlabs.easygrocery.screens.settings.SettingsScreenNavigation
import com.whitecatlabs.easygrocery.screens.settings.settings
import com.whitecatlabs.easygrocery.ui.BottomNavigationBar
import com.whitecatlabs.easygrocery.ui.NavItem
import com.whitecatlabs.easygrocery.ui.theme.AppTheme
import org.koin.compose.viewmodel.koinViewModel

val navBarItems = listOf(
    NavItem(
        icon = Icons.Default.Home,
        selectedIcon = Icons.Default.Home,
        route = MainScreenNavigation,
        title = "Home",
    ),
    NavItem(
        icon = Icons.AutoMirrored.Filled.List,
        selectedIcon = Icons.AutoMirrored.Filled.List,
        route = AddCategoryScreenNavigation,
        title = "Categories",
    ),
    NavItem(
        icon = Icons.Default.Settings,
        selectedIcon = Icons.Default.Settings,
        route = SettingsScreenNavigation,
        title = "Settings",
    ),
)

@Composable
fun App() {
    AppTheme {
        GroceryApp()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Suppress("LongMethod")
@Composable
private fun GroceryApp(navController: NavHostController = rememberNavController()) {
    var appBarTitle: String by remember { mutableStateOf("Home") }
    val navBackStackEntry = navController.currentBackStackEntryAsState().value
    val currentDestination = navBackStackEntry?.destination
    val activityViewModel: ActivityViewModel = koinViewModel()
    Scaffold(
        bottomBar = {
            BottomNavigationBar(items = navBarItems, navController = navController)
        },
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = appBarTitle,
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
                actions = {
                        when (currentDestination?.route) {
                            MainScreenNavigation::class.qualifiedName -> {
                                IconButton(
                                    onClick = {
                                        navController.navigateToCategoryItems(
                                            activityViewModel.selectedCategory.id,
                                            activityViewModel.selectedCategory.title,
                                        )
                                    },
                                ) {
                                    Icon(Icons.Default.Edit, contentDescription = "Edit")
                                }
                            }
                        }
                },
            )
        },
    ) { innerPadding ->
        val uriHandler = LocalUriHandler.current
        NavHost(
            modifier = Modifier.padding(innerPadding),
            navController = navController,
            startDestination = MainScreenNavigation,
        ) {
            main(
                title = { appBarTitle = it },
                navigateToAddCategory = { },
                updateSelectedCategory = { id, title -> },
                navigateBack = { navController.navigateUp() },
            )

            addCategory(
                title = { appBarTitle = it },
                navigateUp = { navController.navigateUp() },
            )

            categoryItems(
                title = { appBarTitle = it },
                navigateUp = { navController.navigateUp() },
            )

            settings(
                title = { appBarTitle = it },
                navigateToPrivacyPolicy = {
                    uriHandler.openUri("https://whitecatlabs.github.io/")
                },
                navigateToContactUs = {
                    uriHandler.openUri("https://whitecatlabs.github.io/")
                },
            )
        }
    }
}

@Suppress("TrailingCommaOnDeclarationSite", "internal:trailing-comma-on-declaration-site")
private fun NavDestination?.shouldShowBackButton(): Boolean =
    when (this?.route) {
        MainScreenNavigation::class.qualifiedName,
        AddCategoryScreenNavigation::class.qualifiedName,
        SettingsScreenNavigation::class.qualifiedName,
            -> false

        else -> true
    }
