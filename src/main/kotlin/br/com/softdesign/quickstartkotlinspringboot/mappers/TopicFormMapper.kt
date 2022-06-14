package br.com.softdesign.quickstartkotlinspringboot.mappers

import br.com.softdesign.quickstartkotlinspringboot.dtos.NewTopicForm
import br.com.softdesign.quickstartkotlinspringboot.models.Topic
import br.com.softdesign.quickstartkotlinspringboot.services.CourseService
import br.com.softdesign.quickstartkotlinspringboot.services.UserService
import org.springframework.stereotype.Component

@Component
class TopicFormMapper(
    private val courseService: CourseService,
    private val userService: UserService
) : Mapper<NewTopicForm, Topic> {
    override fun map(t: NewTopicForm): Topic {
        return Topic(
            title = t.title,
            message = t.message,
            course = courseService.findById(t.courseId)!!,
            author = userService.findById(t.authorId)!!
        )
    }
}
