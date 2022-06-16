package br.com.softdesign.quickstartkotlinspringboot.repositories

import br.com.softdesign.quickstartkotlinspringboot.models.Course
import org.springframework.data.jpa.repository.JpaRepository

interface CourseRepository : JpaRepository<Course, Long>