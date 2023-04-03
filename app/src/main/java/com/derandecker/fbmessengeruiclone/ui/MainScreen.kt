package com.derandecker.fbmessengeruiclone.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.derandecker.fbmessengeruiclone.models.Screen

@CombinedPreviews
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    Scaffold(
        topBar = {
            if (currentDestination != null) {
                TopAppBar(title = { currentDestination.route?.let { Text(it) } })
            }
        },
        bottomBar = {
            BottomBar(
                navController = navController,
                currentDestination = currentDestination
            )
        },
        content = { innerPadding ->
            NavHost(
                navController,
                startDestination = Screen.Chats.route,
                Modifier.padding(innerPadding)
            ) {
                composable(Screen.Chats.route) { ChatScreen(navController) }
                composable(Screen.Calls.route) { CallsScreen(navController) }
                composable(Screen.People.route) { PeopleScreen(navController) }
                composable(Screen.Stories.route) { StoriesScreen(navController) }
            }
        }
    )
}

val bottomNavItems = listOf(
    Screen.Chats,
    Screen.Calls,
    Screen.People,
    Screen.Stories,
)

@Composable
fun BottomBar(
    navController: NavController,
    currentDestination: NavDestination?
) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.background
    ) {
        bottomNavItems.forEach { item ->
            NavigationBarItem(
                selected = currentDestination?.hierarchy?.any { it.route == item.route } == true,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                label = {
                    Text(
                        text = stringResource(id = item.resourceId),
                        fontWeight = FontWeight.SemiBold,
                    )
                },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = "${stringResource(id = item.resourceId)} Icon",
                    )
                }
            )
        }
    }
}

@Composable
fun CallsScreen(navController: NavController) {
    Text(text = "CALLS!")
}

@Composable
fun PeopleScreen(navController: NavController) {
    Text(text = "PEOPLE!")
}

@Composable
fun StoriesScreen(navController: NavController) {
    Text(text = "STORIES!")
}
