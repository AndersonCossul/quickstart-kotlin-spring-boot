package br.com.softdesign.quickstartkotlinspringboot.services

import br.com.softdesign.quickstartkotlinspringboot.exceptions.NotFoundException
import br.com.softdesign.quickstartkotlinspringboot.models.Course
import br.com.softdesign.quickstartkotlinspringboot.repositories.CourseRepository
import org.springframework.stereotype.Service

@Service
class CourseService(private val repository: CourseRepository) {
    fun findById(id: Long): Course {
        val opt = repository.findById(id)
        if (opt.isEmpty) {
            throw NotFoundException("Course not found for id $id")
        }
        return opt.get()
    }
}
