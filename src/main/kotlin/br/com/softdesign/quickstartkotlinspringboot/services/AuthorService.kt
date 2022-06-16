package br.com.softdesign.quickstartkotlinspringboot.services

import br.com.softdesign.quickstartkotlinspringboot.exceptions.NotFoundException
import br.com.softdesign.quickstartkotlinspringboot.models.Author
import br.com.softdesign.quickstartkotlinspringboot.repositories.AuthorRepository
import org.springframework.stereotype.Service

@Service
class AuthorService(private val repository: AuthorRepository) {
    fun findById(id: Long): Author {
        val opt = repository.findById(id)
        if (opt.isEmpty) {
            throw NotFoundException("Author not found for id $id")
        }
        return opt.get()
    }
}
