package com.derandecker.fbmessengeruiclone.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Face
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.ui.graphics.vector.ImageVector
import com.derandecker.fbmessengeruiclone.R

sealed class Screen(val route: String, @StringRes val resourceId: Int, val icon: ImageVector) {
    object Chats : Screen("Chats", R.string.chats, icon = Icons.Rounded.Face)
    object Calls : Screen("Calls", R.string.calls, icon = Icons.Rounded.Phone)
    object People : Screen("People", R.string.people, icon = Icons.Rounded.Person)
    object Stories : Screen("Stories", R.string.stories, icon = Icons.Rounded.Info)
}
