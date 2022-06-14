package br.com.softdesign.quickstartkotlinspringboot.mappers

interface Mapper<T, U> {
    fun map(t: T): U
}
