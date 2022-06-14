package br.com.softdesign.quickstartkotlinspringboot.models

import java.time.LocalDateTime

data class Topic(
    var id: Long? = null,
    val title: String,
    val message: String,
    val course: Course,
    val author: User,
    val status: TopicStatus = TopicStatus.NOT_ANSWERED,
    val answers: List<Answer> = ArrayList(),
    val createdAt: LocalDateTime = LocalDateTime.now()
)