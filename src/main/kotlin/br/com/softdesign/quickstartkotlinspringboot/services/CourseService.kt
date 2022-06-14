package br.com.softdesign.quickstartkotlinspringboot.services

import br.com.softdesign.quickstartkotlinspringboot.exceptions.NotFoundException
import br.com.softdesign.quickstartkotlinspringboot.models.Course
import org.springframework.stereotype.Service

@Service
class CourseService(
    private var courses: MutableList<Course>
) {
    init {
        val course = Course(
            id = 1,
            name = "Kotlin",
            category = "Programming"
        )
        courses = mutableListOf(course)
    }

    fun findById(id: Long): Course {
        return courses.find { x -> x.id == id } ?: throw NotFoundException("Course not found for id $id")
    }
}
