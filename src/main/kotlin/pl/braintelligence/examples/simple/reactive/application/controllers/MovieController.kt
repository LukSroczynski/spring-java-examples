package pl.braintelligence.examples.simple.reactive.application.controllers

import org.slf4j.LoggerFactory
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import pl.braintelligence.examples.simple.reactive.application.domain.Movie
import pl.braintelligence.examples.simple.reactive.application.domain.MovieEvent
import pl.braintelligence.examples.simple.reactive.application.service.MovieService
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.lang.invoke.MethodHandles

@RestController
@RequestMapping("/movies")
class MovieController(
        val movieService: MovieService
) {

    @GetMapping(value = ["/{id}/events"], produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    fun streamMovieEvents(@PathVariable id: String): Flux<MovieEvent> {

        logger.info("Movies with: $id")
        return movieService.events(id)
    }

    @GetMapping(value = ["/{id}"])
    fun getMovieById(@PathVariable id: String): Mono<Movie> {

        return movieService.getMovieById(id)
    }

    @GetMapping
    fun getAllMovies(): Flux<Movie> {

        return movieService.getAllMovies()
    }

    companion object {
        private val logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass())
    }
}
