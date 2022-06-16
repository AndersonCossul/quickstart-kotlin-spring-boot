package br.com.softdesign.quickstartkotlinspringboot.repositories

import br.com.softdesign.quickstartkotlinspringboot.models.Author
import org.springframework.data.jpa.repository.JpaRepository

interface AuthorRepository : JpaRepository<Author, Long>