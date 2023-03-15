package com.derandecker.fbmessengeruiclone.utils

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

/* return appropriate formatter to either display time as "07:20 pm" if
    message timestamp was within past 24 hrs, else display time as "Feb 28"
 */
fun customTimeFormatter(time: LocalDateTime): DateTimeFormatter {
    val target = LocalDateTime.now().minusHours(24)
    return if (time > target) {
        DateTimeFormatter.ofPattern("hh:mm a")
    } else DateTimeFormatter.ofPattern("MMM dd")
}
