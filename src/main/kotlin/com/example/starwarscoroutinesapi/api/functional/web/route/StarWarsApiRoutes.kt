package com.example.starwarscoroutinesapi.api.functional.web.route

import com.example.starwarscoroutinesapi.api.functional.web.handler.StarWarsApiHandlers
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class StarWarsApiRoutes(private val starWarsApiHandlers: StarWarsApiHandlers) {

    @Bean
    fun starWarsApiRouter() = coRouter {
        GET("/functionalapi/people/{id}", starWarsApiHandlers::getCharacter)
    }

}