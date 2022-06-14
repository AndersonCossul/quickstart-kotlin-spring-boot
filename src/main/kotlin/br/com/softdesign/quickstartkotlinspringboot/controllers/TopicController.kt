package br.com.softdesign.quickstartkotlinspringboot.controllers

import br.com.softdesign.quickstartkotlinspringboot.dtos.NewTopicForm
import br.com.softdesign.quickstartkotlinspringboot.dtos.TopicView
import br.com.softdesign.quickstartkotlinspringboot.dtos.UpdateTopicForm
import br.com.softdesign.quickstartkotlinspringboot.services.TopicService
import org.springframework.web.bind.annotation.*
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
    fun findById(@PathVariable id: Long): TopicView? {
        return topicService.findById(id)
    }

    @PostMapping
    fun create(@RequestBody @Valid form: NewTopicForm): TopicView {
        return topicService.create(form)
    }

    @PutMapping
    fun update(@RequestBody @Valid form: UpdateTopicForm): TopicView? {
        return topicService.update(form)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) {
        topicService.delete(id)
    }
}