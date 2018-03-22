package pl.braintelligence.examples.netflux.controllers

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import pl.braintelligence.examples.netflux.domain.MovieEvent
import pl.braintelligence.examples.netflux.service.MovieService
import reactor.core.publisher.Flux
import java.lang.invoke.MethodHandles

@RestController
@RequestMapping("/movies")
class MovieController(
        val movieService: MovieService
) {

    @GetMapping(value = ["/{id}/events"])
    fun streamMovieEvents(
            @PathVariable id: String
    ): Flux<MovieEvent> {

        logger.info("Movie with id: $id")

        return movieService.events(id)
    }

    companion object {
        private val logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass())
    }
}
