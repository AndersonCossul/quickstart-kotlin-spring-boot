package br.com.softdesign.quickstartkotlinspringboot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@SpringBootApplication
@EnableCaching
class QuickstartKotlinSpringBootApplication

fun main(args: Array<String>) {
    runApplication<QuickstartKotlinSpringBootApplication>(*args)
}
