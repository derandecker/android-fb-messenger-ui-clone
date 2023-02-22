package com.derandecker.fbmessengeruiclone.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.derandecker.fbmessengeruiclone.ui.theme.FBMessengerUICloneTheme

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FBMessengerUICloneTheme {
        MainScreen()
    }
}

@Composable
fun MainScreen() {
    Text(text = "Hello There!")
}
