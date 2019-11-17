package com.example.starwarscoroutinesapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class StarWarsCoroutinesApiApplication

fun main(args: Array<String>) {
	runApplication<StarWarsCoroutinesApiApplication>(*args)
}
