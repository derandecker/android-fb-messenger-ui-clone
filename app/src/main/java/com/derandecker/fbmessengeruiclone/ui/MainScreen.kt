package com.derandecker.fbmessengeruiclone.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.derandecker.fbmessengeruiclone.ui.theme.FBMessengerUICloneTheme

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FBMessengerUICloneTheme {
        MainScreen()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    Scaffold(
        bottomBar = {
            androidx.compose.material3.NavigationBar(
                containerColor = MaterialTheme.colorScheme.background,
            ) {
                NavigationBarItem(
                    selected = true,
                    onClick = { },
                    label = {
                        Text(
                            text = "Home",
                            fontWeight = FontWeight.SemiBold,
                        )
                    },
                    icon = {
                        Icon(imageVector = Icons.Rounded.Home, contentDescription = "")
                    }
                )
            }
        },
        content = {
            PaddingValues(
                top = it.calculateTopPadding()
            )
//           NavHost
        }
    )
}
