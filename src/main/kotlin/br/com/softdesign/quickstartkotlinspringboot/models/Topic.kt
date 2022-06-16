package br.com.softdesign.quickstartkotlinspringboot.models

import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Topic(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var title: String,
    var message: String,
    @ManyToOne
    val course: Course,
    @ManyToOne
    val author: Author,
    @Enumerated(value = EnumType.STRING)
    val status: TopicStatus = TopicStatus.NOT_ANSWERED,
    @OneToMany(mappedBy = "topic")
    val answers: List<Answer> = ArrayList(),
    val createdAt: LocalDateTime = LocalDateTime.now()
)