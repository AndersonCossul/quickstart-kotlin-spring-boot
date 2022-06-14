package br.com.softdesign.quickstartkotlinspringboot.dtos

import br.com.softdesign.quickstartkotlinspringboot.models.TopicStatus
import java.time.LocalDateTime

data class TopicView(
    val id: Long?,
    val title: String,
    val message: String,
    val status: TopicStatus,
    val createdAt: LocalDateTime
)
