package com.derandecker.fbmessengeruiclone.models

import androidx.annotation.DrawableRes
import java.time.LocalDateTime

data class ChatItemData(
    val name: String,
    val message: String,
    val time: LocalDateTime,
    @DrawableRes val profilePicture: Int
)
