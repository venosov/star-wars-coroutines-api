package com.example.starwarscoroutinesapi.client

import com.example.starwarscoroutinesapi.dto.Character
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToFlow

@Component
class StarWarsApiWebClient {

    private val webClient = WebClient.builder()

    fun findCharacter(id: Int) = webClient.baseUrl("https://swapi.co/api/").build()
                .get().uri("/people/$id/")
                .header("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON).retrieve()
                .bodyToFlow<Character>()

}