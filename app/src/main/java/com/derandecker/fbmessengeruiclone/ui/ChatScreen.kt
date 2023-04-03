package com.derandecker.fbmessengeruiclone.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.derandecker.fbmessengeruiclone.R
import com.derandecker.fbmessengeruiclone.data.chatListItems
import com.derandecker.fbmessengeruiclone.utils.customTimeFormatter
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

val defaultTimeFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy hh:mm a")

@CombinedPreviews
@Composable
fun ChatScreenTabletPreview() {
    ChatScreen(navController = rememberNavController())
}

@Composable
fun ChatScreen(navController: NavController) {
    Column(modifier = Modifier.padding(top = 8.dp)) {
        SearchBox(modifier = Modifier.padding(start = 16.dp, end = 16.dp))
        RecentContactsList(modifier = Modifier.padding(start = 2.dp))
        ChatList(modifier = Modifier.padding(start = 16.dp, end = 16.dp))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBox(
    modifier: Modifier = Modifier
) {
    var text by rememberSaveable { mutableStateOf("") }
    TextField(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        value = text,
        shape = CircleShape,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        onValueChange = { text = it },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null
            )
        },
        singleLine = true,
        placeholder = {
            Text(
                stringResource(R.string.search),
            )
        },
    )
}

@Composable
fun RecentContactsList(modifier: Modifier) {
    LazyRow(
        modifier = modifier
            .padding(top = 8.dp, bottom = 8.dp)
    ) {
        items(chatListItems(defaultTimeFormatter)) {
            RecentContactItem(profilePicture = it.profilePicture, name = it.name)
        }
    }
}

@Composable
fun ChatList(modifier: Modifier) {
    LazyColumn(modifier = modifier) {
        // add key when using real data
        // TODO: time is parsed twice. Look into solutions.
        items(items = chatListItems(defaultTimeFormatter)) {
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
            overflow = TextOverflow.Ellipsis,
            lineHeight = 12.sp
        )
    }
}

@Composable
fun ChatItem(
    name: String,
    message: String,
    time: LocalDateTime,
    @DrawableRes profilePicture: Int
) {
    Row(
        modifier = Modifier
            .padding(bottom = 16.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        ProfilePic(profilePicture = profilePicture)
        Column(
            modifier = Modifier
                .padding(start = 16.dp)
                .fillMaxWidth()
        ) {
            Text(text = name)
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    modifier = Modifier.weight(2f),
                    text = message,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
                Text(text = " • ")
                Text(
                    modifier = Modifier.weight(1f),
                    // TODO: time is parsed twice. Look into solutions.
                    text = time.format(customTimeFormatter(time)),
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
            }
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
