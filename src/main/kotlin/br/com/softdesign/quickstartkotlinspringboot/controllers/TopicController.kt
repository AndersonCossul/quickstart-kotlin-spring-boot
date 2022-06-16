package br.com.softdesign.quickstartkotlinspringboot.controllers

import br.com.softdesign.quickstartkotlinspringboot.dtos.NewTopicForm
import br.com.softdesign.quickstartkotlinspringboot.dtos.TopicView
import br.com.softdesign.quickstartkotlinspringboot.dtos.UpdateTopicForm
import br.com.softdesign.quickstartkotlinspringboot.services.TopicService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/topics")
class TopicController(
    private val topicService: TopicService
) {
    @GetMapping
    fun list(): List<TopicView> {
        return topicService.list()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): TopicView {
        return topicService.findById(id)
    }

    @PostMapping
    @Transactional
    fun create(
        @RequestBody @Valid form: NewTopicForm,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<TopicView> {
        val topicView = topicService.create(form)
        val uri = uriBuilder.path("/topics/${topicView.id}").build().toUri()
        return ResponseEntity.created(uri).body(topicView)
    }

    @PutMapping
    @Transactional
    fun update(@RequestBody @Valid form: UpdateTopicForm): TopicView {
        return topicService.update(form)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    fun delete(@PathVariable id: Long) {
        topicService.delete(id)
    }
}