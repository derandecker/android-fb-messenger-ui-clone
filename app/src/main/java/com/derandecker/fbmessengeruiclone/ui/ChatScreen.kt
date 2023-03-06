package com.derandecker.fbmessengeruiclone.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.derandecker.fbmessengeruiclone.R
import com.derandecker.fbmessengeruiclone.chatListItems
import com.derandecker.fbmessengeruiclone.recentContactsList
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy hh:mm a")

@Preview
@Composable
fun ChatScreenPreview() {
    ChatScreen(navController = rememberNavController())
}


@Composable
fun ChatScreen(navController: NavController) {
    Column(Modifier.padding(top = 8.dp, start = 8.dp)) {
        SearchBox()
        RecentContactsList()
        ChatList()
    }
}

@Composable
fun SearchBox() {
    Text("Search Box Placeholder")
}

@Composable
fun RecentContactsList() {
    LazyRow(modifier = Modifier.padding(8.dp)) {
        items(recentContactsList) {
            Text(
                text = it,
                Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
fun ChatList() {
    LazyColumn {
        // add key when using real data
        items(items = chatListItems) {
            ChatItem(it.name, it.message, it.time, it.profilePicture)
        }
    }
}

@Composable
fun ChatItem(name: String, message: String, time: LocalDateTime, @DrawableRes profilePicture: Int) {
    Row(modifier = Modifier.padding(bottom = 8.dp)) {
        Image(
            modifier = Modifier.size(40.dp)
                .clip(CircleShape),
            painter = painterResource(id = profilePicture),
            contentDescription = stringResource(R.string.profile_picture)
        )
        Column(modifier = Modifier.padding(start = 8.dp)) {
            Text(text = name)
            Text(text = "$message ${time.format(formatter)}")
        }
    }
}

@Composable
fun RecentContactItem() {
}
