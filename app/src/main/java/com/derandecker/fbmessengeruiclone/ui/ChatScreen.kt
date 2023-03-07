package com.derandecker.fbmessengeruiclone.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.derandecker.fbmessengeruiclone.R
import com.derandecker.fbmessengeruiclone.data.chatListItems
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy hh:mm a")

//region Previews
@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFF,
    device = Devices.PIXEL_4_XL
)
@Composable
fun ChatScreenPreview() {
    ChatScreen(navController = rememberNavController())
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFF,
    device = Devices.FOLDABLE
)
@Composable
fun ChatScreenFoldablePreview() {
    ChatScreen(navController = rememberNavController())
}


@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFF,
    device = Devices.TABLET
)
@Composable
fun ChatScreenTabletPreview() {
    ChatScreen(navController = rememberNavController())
}
//endregion

@Composable
fun ChatScreen(navController: NavController) {
    Column(modifier = Modifier.padding(top = 8.dp)) {
        SearchBox(modifier = Modifier.padding(start = 8.dp))
        RecentContactsList(modifier = Modifier.padding(start = 2.dp))
        ChatList(modifier = Modifier.padding(start = 16.dp, end = 16.dp))
    }
}

@Composable
fun SearchBox(modifier: Modifier) {
    Text(
        modifier = modifier,
        text = "Search Box Placeholder"
    )
}

@Composable
fun RecentContactsList(modifier: Modifier) {
    LazyRow(
        modifier = modifier
            .padding(top = 8.dp, bottom = 8.dp)
    ) {
        items(chatListItems(formatter)) {
            RecentContactItem(profilePicture = it.profilePicture, name = it.name)
        }
    }
}

@Composable
fun ChatList(modifier: Modifier) {
    LazyColumn(modifier = modifier) {
        // add key when using real data
        items(items = chatListItems(formatter)) {
            ChatItem(it.name, it.message, it.time, it.profilePicture)
        }
    }
}

@Composable
fun RecentContactItem(@DrawableRes profilePicture: Int, name: String) {
    Column(
        modifier = Modifier.width(58.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ProfilePic(profilePicture = profilePicture)
        Text(
            modifier = Modifier
                .padding(top = 4.dp),
            fontSize = 10.sp,
            text = name,
            textAlign = TextAlign.Center,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
fun ChatItem(name: String, message: String, time: LocalDateTime, @DrawableRes profilePicture: Int) {
    Row(
        modifier = Modifier.padding(bottom = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        ProfilePic(profilePicture = profilePicture)
        Column(modifier = Modifier.padding(start = 16.dp)) {
            Text(text = name)
            Text(
                text = "$message ${time.format(formatter)}",
                overflow = TextOverflow.Ellipsis, maxLines = 1
            )
        }
    }
}

@Composable
fun ProfilePic(@DrawableRes profilePicture: Int) {
    Image(
        modifier = Modifier
            .size(50.dp)
            .clip(CircleShape),
        painter = painterResource(id = profilePicture),
        contentDescription = stringResource(R.string.profile_picture)
    )
}
