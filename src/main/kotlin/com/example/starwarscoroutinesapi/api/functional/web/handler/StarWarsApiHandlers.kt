package com.example.starwarscoroutinesapi.api.functional.web.handler

import com.example.starwarscoroutinesapi.client.StarWarsApiWebClient
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.bodyAndAwait

@Component
class StarWarsApiHandlers(private val starWarsApiWebClient: StarWarsApiWebClient) {

    suspend fun getCharacter(serverRequest: ServerRequest) = ok().bodyAndAwait(starWarsApiWebClient.findCharacter(serverRequest.pathVariable("id").toInt()))

}
