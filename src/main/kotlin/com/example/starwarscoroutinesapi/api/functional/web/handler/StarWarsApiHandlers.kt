package com.example.starwarscoroutinesapi.api.functional.web.handler

import com.example.starwarscoroutinesapi.client.StarWarsApiWebClient
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flatMapConcat
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.bodyAndAwait

@Component
class StarWarsApiHandlers(private val starWarsApiWebClient: StarWarsApiWebClient) {

    suspend fun getCharacter(serverRequest: ServerRequest) = ok().bodyAndAwait(starWarsApiWebClient.findCharacter(serverRequest.pathVariable("id").toInt()))

    suspend fun getCharacterFilms(serverRequest: ServerRequest) = ok()
            .bodyAndAwait(starWarsApiWebClient.findCharacter(serverRequest.pathVariable("id").toInt())
                    .flatMapConcat {
                        it.films.asFlow()
                    }.flatMapConcat {
                        starWarsApiWebClient.findFilm(it)
                    })

}
