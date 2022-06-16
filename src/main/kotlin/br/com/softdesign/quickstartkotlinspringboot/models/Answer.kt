package br.com.softdesign.quickstartkotlinspringboot.models

import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Answer(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val message: String,
    @ManyToOne
    val author: Author,
    @ManyToOne
    val topic: Topic,
    val solves: Boolean,
    val createdAt: LocalDateTime = LocalDateTime.now()
)
