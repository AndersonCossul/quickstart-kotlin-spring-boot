package br.com.softdesign.quickstartkotlinspringboot.services

import br.com.softdesign.quickstartkotlinspringboot.exceptions.NotFoundException
import br.com.softdesign.quickstartkotlinspringboot.models.User
import org.springframework.stereotype.Service

@Service
class UserService(
    private var users: MutableList<User>
) {
    init {
        val user = User(
            id = 1,
            name = "Anderson Cossul",
            email = "anderson_cossul@hotmail.com"
        )

        users = mutableListOf(user)
    }

    fun findById(id: Long): User {
        return users.find { x -> x.id == id } ?: throw NotFoundException("User not found for id $id")
    }
}
