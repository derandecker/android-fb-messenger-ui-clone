package com.derandecker.fbmessengeruiclone.ui

import android.content.res.Configuration
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.derandecker.fbmessengeruiclone.ui.theme.FBMessengerUICloneTheme

@Preview(showBackground = true)
@Composable
fun LightModePreview() {
    FBMessengerUICloneTheme {
        MainScreen()
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DarkModePreview() {
    FBMessengerUICloneTheme {
        MainScreen()
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    Scaffold(
        bottomBar = {
            androidx.compose.material3.NavigationBar(
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
        }, content = { innerPadding ->
            NavHost(
                navController,
                startDestination = Screen.Chats.route,
                Modifier.padding(innerPadding)
            ) {
                composable(Screen.Chats.route) { Chats(navController) }
                composable(Screen.Calls.route) { Calls(navController) }
                composable(Screen.People.route) { People(navController) }
                composable(Screen.Stories.route) { Stories(navController) }
            }
        }
    )
}


val bottomNavItems = listOf(
    Screen.Chats,
    Screen.Calls,
    Screen.People,
    Screen.Stories
)

@Composable
fun Chats(navController: NavController) {
    Text(text = "CHATS!")
}

@Composable
fun Calls(navController: NavController) {
    Text(text = "CALLS!")
}

@Composable
fun People(navController: NavController) {
    Text(text = "PEOPLE!")
}

@Composable
fun Stories(navController: NavController) {
    Text(text = "STORIES!")
}
