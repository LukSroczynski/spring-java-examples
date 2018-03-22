package pl.braintelligence.examples.netflux.service

import pl.braintelligence.examples.netflux.domain.Movie
import pl.braintelligence.examples.netflux.domain.MovieEvent
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface MovieService {
    fun events(movieId: String): Flux<MovieEvent>
    fun getMovieById(id: String): Mono<Movie>
    fun getAllMovies(): Flux<Movie>
}