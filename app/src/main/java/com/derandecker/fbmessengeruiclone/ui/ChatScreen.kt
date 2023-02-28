package com.derandecker.fbmessengeruiclone.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

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
            ChatItem(it)
        }
    }
}

@Composable
fun ChatItem(name: String) {
    Row(modifier = Modifier.padding(bottom = 8.dp)) {
        Box(
            modifier = Modifier
                .background(Color.Blue)
                .size(40.dp)
        )
        Column(modifier = Modifier.padding(start = 4.dp)) {
            Text(text = name)
            Text(text = "Sample recent chat text" + " * 9:99 pm")
        }
    }
}

@Composable
fun RecentContactItem() {

}

val recentContactsList = listOf("Jane Doe", "John Doe", "Jim Doe")
val chatListItems = listOf(
    "Kim Doe",
    "Amy Doe",
    "James Doe",
    "Kim Doe",
    "Amy Doe",
    "James Doe",
    "Kim Doe",
    "Amy Doe",
    "James Doe",
    "Kim Doe",
    "Amy Doe",
    "James Doe",
    "Kim Doe",
    "Amy Doe",
    "James Doe",
    "Kim Doe",
    "Amy Doe",
    "James Doe",
    "Kim Doe",
    "Amy Doe",
    "James Doe",
    "Kim Doe",
    "Amy Doe",
    "James Doe",
    "Kim Doe",
    "Amy Doe",
    "James Doe",
)
