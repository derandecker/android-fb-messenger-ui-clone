package com.derandecker.fbmessengeruiclone.data

import com.derandecker.fbmessengeruiclone.R
import com.derandecker.fbmessengeruiclone.models.ChatItemData
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

// fake data generated with help of ChatGPT
// fake profile photos via https://xsgames.co/randomusers/

fun chatListItems(formatter: DateTimeFormatter): List<ChatItemData> {
    return listOf(
        ChatItemData(
            name = "John Smith",
            message = "Hey, what's up? Haven't talked in a while!",
            time = LocalDateTime.parse("03-13-2023 07:20 PM", formatter),
            profilePicture = R.drawable.a1
        ),
        ChatItemData(
            name = "Sarah Johnson",
            message = "Not much, just hanging out at home. How about you?",
            time = LocalDateTime.parse("03-04-2023 04:15 PM", formatter),
            profilePicture = R.drawable.a2
        ),
        ChatItemData(
            name = "Michael Brown",
            message = "Hey, did you get that email I sent you?",
            time = LocalDateTime.parse("03-03-2023 10:30 AM", formatter),
            profilePicture = R.drawable.a3
        ),
        ChatItemData(
            name = "Emily Davis",
            message = "Yeah, I got it. I'll take a look at it later.",
            time = LocalDateTime.parse("03-14-2023 06:45 PM", formatter),
            profilePicture = R.drawable.a4
        ),
        ChatItemData(
            name = "Amanda Garcia",
            message = "Hey, can you give me a call when you have a minute?",
            time = LocalDateTime.parse("03-01-2023 02:25 PM", formatter),
            profilePicture = R.drawable.a5
        ),
        ChatItemData(
            name = "Christopher Wilson",
            message = "Sure, what's up?",
            time = LocalDateTime.parse("03-14-2023 02:10 AM", formatter),
            profilePicture = R.drawable.a6
        ),
        ChatItemData(
            name = "David Martinez",
            message = "Just wanted to check in and see how you're doing.",
            time = LocalDateTime.parse("02-27-2023 08:05 PM", formatter),
            profilePicture = R.drawable.a7
        ),
        ChatItemData(
            name = "Jennifer Rodriguez",
            message = "I'm doing pretty well, thanks for asking.",
            time = LocalDateTime.parse("02-26-2023 01:50 PM", formatter),
            profilePicture = R.drawable.a8
        ),
        ChatItemData(
            name = "Robert Lee",
            message = "Hey, do you have any plans for the weekend?",
            time = LocalDateTime.parse("02-25-2023 09:35 AM", formatter),
            profilePicture = R.drawable.a9
        ),
        ChatItemData(
            name = "Karen Jackson",
            message = "Not really, just planning on relaxing at home. Why do you ask?",
            time = LocalDateTime.parse("02-24-2023 03:20 PM", formatter),
            profilePicture = R.drawable.a10
        ),
        ChatItemData(
            name = "Matthew Wilson",
            message = "Hey, did you see that new movie that just came out?",
            time = LocalDateTime.parse("03-06-2023 12:45 PM", formatter),
            profilePicture = R.drawable.a11
        ),
        ChatItemData(
            name = "Laura Davis",
            message = "No, I haven't. What's it called?",
            time = LocalDateTime.parse("03-05-2023 07:30 PM", formatter),
            profilePicture = R.drawable.a12
        ),
        ChatItemData(
            name = "Brandon Rodriguez",
            message = "It's called The Last Stand. It's supposed to be really good.",
            time = LocalDateTime.parse("03-04-2023 02:15 PM", formatter),
            profilePicture = R.drawable.a13
        ),
        ChatItemData(
            name = "Jessica Hernandez",
            message = "I heard about that one. Maybe we can go see it together?",
            time = LocalDateTime.parse("03-03-2023 09:00 AM", formatter),
            profilePicture = R.drawable.a14
        ),
        ChatItemData(
            name = "David Thompson",
            message = "Sounds like a plan. When were you thinking?",
            time = LocalDateTime.parse("03-02-2023 04:30 PM", formatter),
            profilePicture = R.drawable.a15
        ),
        ChatItemData(
            name = "Ashley Martinez",
            message = "How about this Saturday evening?",
            time = LocalDateTime.parse("03-01-2023 11:45 AM", formatter),
            profilePicture = R.drawable.a16
        ),
        ChatItemData(
            name = "Mark Johnson",
            message = "That works for me. What time?",
            time = LocalDateTime.parse("02-28-2023 08:30 PM", formatter),
            profilePicture = R.drawable.a17
        ),
        ChatItemData(
            name = "Catherine Brown",
            message = "Let's aim for 7pm. Does that work?",
            time = LocalDateTime.parse("02-27-2023 03:15 PM", formatter),
            profilePicture = R.drawable.a18
        ),
        ChatItemData(
            name = "Jacob Thomas",
            message = "Sounds good. Where should we meet?",
            time = LocalDateTime.parse("02-26-2023 10:00 AM", formatter),
            profilePicture = R.drawable.a19
        ),
        ChatItemData(
            name = "Olivia Davis",
            message = "How about at the theater? We can get our tickets there.",
            time = LocalDateTime.parse("02-25-2023 05:45 PM", formatter),
            profilePicture = R.drawable.a20
        ),
        ChatItemData(
            name = "Ethan Lee",
            message = "Great idea. I'll see you there at 7pm.",
            time = LocalDateTime.parse("02-24-2023 12:30 PM", formatter),
            profilePicture = R.drawable.a21
        ),
        ChatItemData(
            name = "Sophia Wilson",
            message = "See you then!",
            time = LocalDateTime.parse("02-23-2023 09:15 PM", formatter),
            profilePicture = R.drawable.a22
        ),
        ChatItemData(
            name = "Daniel Jackson",
            message = "Hey, did you see the game last night?",
            time = LocalDateTime.parse("02-22-2023 04:00 PM", formatter),
            profilePicture = R.drawable.a23
        ),
        ChatItemData(
            name = "Avery Parker",
            message = "Hey, are you free tonight? I was thinking we could grab dinner.",
            time = LocalDateTime.parse("03-06-2023 07:45 PM", formatter),
            profilePicture = R.drawable.a24
        ),
        ChatItemData(
            name = "Logan Evans",
            message = "Sorry, I'm not available tonight. How about tomorrow?",
            time = LocalDateTime.parse("03-05-2023 12:30 PM", formatter),
            profilePicture = R.drawable.a25
        )
    )
}

