package com.example.memopractice

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class Memo(var title: String, var content: String, var timestamp: LocalDateTime = LocalDateTime.now()) {
    fun formattedTime(): String = timestamp.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
}
