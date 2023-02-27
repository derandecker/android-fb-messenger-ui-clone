package com.derandecker.fbmessengeruiclone.ui

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Face
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.ui.graphics.vector.ImageVector
import com.derandecker.fbmessengeruiclone.R

sealed class Screen(val route: String, @StringRes val resourceId: Int, val icon: ImageVector) {
    object Chats : Screen("chats", R.string.chats, icon = Icons.Rounded.Face)
    object Calls : Screen("calls", R.string.calls, icon = Icons.Rounded.Phone)
    object People : Screen("people", R.string.people, icon = Icons.Rounded.Person)
    object Stories : Screen("stories", R.string.stories, icon = Icons.Rounded.Info)
}
