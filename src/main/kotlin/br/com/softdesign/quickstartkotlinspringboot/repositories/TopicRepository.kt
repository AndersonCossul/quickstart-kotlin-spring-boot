package br.com.softdesign.quickstartkotlinspringboot.repositories

import br.com.softdesign.quickstartkotlinspringboot.models.Topic
import org.springframework.data.jpa.repository.JpaRepository

interface TopicRepository : JpaRepository<Topic, Long>