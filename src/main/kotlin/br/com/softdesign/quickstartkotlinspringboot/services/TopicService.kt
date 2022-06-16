package br.com.softdesign.quickstartkotlinspringboot.services

import br.com.softdesign.quickstartkotlinspringboot.dtos.NewTopicForm
import br.com.softdesign.quickstartkotlinspringboot.dtos.TopicByCategoryDto
import br.com.softdesign.quickstartkotlinspringboot.dtos.TopicView
import br.com.softdesign.quickstartkotlinspringboot.dtos.UpdateTopicForm
import br.com.softdesign.quickstartkotlinspringboot.exceptions.NotFoundException
import br.com.softdesign.quickstartkotlinspringboot.mappers.TopicFormMapper
import br.com.softdesign.quickstartkotlinspringboot.mappers.TopicViewMapper
import br.com.softdesign.quickstartkotlinspringboot.repositories.TopicRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import javax.persistence.EntityManager

@Service
class TopicService(
    private val repository: TopicRepository,
    private val topicViewMapper: TopicViewMapper,
    private val topicFormMapper: TopicFormMapper,
    private val em: EntityManager // in case you need it for some obscure reason, here it is
) {
    fun list(
        courseName: String?,
        pagination: Pageable
    ): Page<TopicView> {
        val topics = if (courseName == null) {
            repository.findAll(pagination)
        } else {
            repository.findByCourseName(courseName, pagination)
        }
        return topics.map { t -> topicViewMapper.map(t) }
    }

    fun findById(id: Long): TopicView {
        val optional = repository.findById(id)
        if (optional.isEmpty) {
            throw NotFoundException("Topic not found for id $id")
        }
        return topicViewMapper.map(optional.get())
    }

    fun create(form: NewTopicForm): TopicView {
        val topic = topicFormMapper.map(form)
        repository.save(topic)
        return topicViewMapper.map(topic)
    }

    fun update(form: UpdateTopicForm): TopicView {
        val optional = repository.findById(form.id)
        if (optional.isEmpty) {
            throw NotFoundException("Topic not found for id ${form.id}")
        }
        val topic = optional.get()
        topic.title = form.title
        topic.message = form.message
        return topicViewMapper.map(topic)
    }

    fun delete(id: Long) {
        val optional = repository.findById(id)
        if (optional.isEmpty) {
            throw NotFoundException("Topic not found for id $id")
        }
        repository.delete(optional.get())
    }

    fun report(): List<TopicByCategoryDto> {
        return repository.report()
    }
}