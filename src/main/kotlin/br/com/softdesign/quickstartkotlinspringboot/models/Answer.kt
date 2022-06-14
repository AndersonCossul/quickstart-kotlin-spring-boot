package br.com.softdesign.quickstartkotlinspringboot.models

import java.time.LocalDateTime

data class Answer(
    val id: Long? = null,
    val message: String,
    val author: User,
    val topic: Topic,
    val solves: Boolean,
    val createdAt: LocalDateTime = LocalDateTime.now()
)
