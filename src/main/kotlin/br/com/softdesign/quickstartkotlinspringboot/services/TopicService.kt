package br.com.softdesign.quickstartkotlinspringboot.services

import br.com.softdesign.quickstartkotlinspringboot.dtos.NewTopicForm
import br.com.softdesign.quickstartkotlinspringboot.dtos.TopicView
import br.com.softdesign.quickstartkotlinspringboot.dtos.UpdateTopicForm
import br.com.softdesign.quickstartkotlinspringboot.exceptions.NotFoundException
import br.com.softdesign.quickstartkotlinspringboot.mappers.TopicFormMapper
import br.com.softdesign.quickstartkotlinspringboot.mappers.TopicViewMapper
import br.com.softdesign.quickstartkotlinspringboot.models.Topic
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicService(
    private var topics: MutableList<Topic> = ArrayList(),
    private val topicViewMapper: TopicViewMapper,
    private val topicFormMapper: TopicFormMapper,
) {
    fun list(): List<TopicView> {
        return topics.stream().map { t ->
            topicViewMapper.map(t)
        }.collect(Collectors.toList())
    }

    fun findById(id: Long): TopicView {
        val topic = topics.find { t -> t.id == id } ?: throw NotFoundException("Topic not found for id $id")
        return topicViewMapper.map(topic)
    }

    fun create(form: NewTopicForm): TopicView {
        val topic = topicFormMapper.map(form)
        topic.id = topics.size.toLong() + 1
        topics.add(topic)
        return topicViewMapper.map(topic)
    }

    fun update(form: UpdateTopicForm): TopicView {
        val topic = topics.find { t -> t.id == form.id } ?: throw NotFoundException("Topic not found for id ${form.id}")
        val newTopic = Topic(
            id = form.id,
            title = form.title,
            message = form.message,
            author = topic.author,
            course = topic.course,
            answers = topic.answers,
            status = topic.status,
            createdAt = topic.createdAt
        )

        topics.remove(topic)
        topics.add(newTopic)
        return topicViewMapper.map(newTopic)
    }

    fun delete(id: Long) {
        val topic = topics.find { t -> t.id == id } ?: throw NotFoundException("Topic not found for id $id")
        topics.remove(topic)
    }
}