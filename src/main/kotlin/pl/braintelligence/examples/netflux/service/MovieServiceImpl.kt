package pl.braintelligence.examples.netflux.service

import org.springframework.stereotype.Service
import pl.braintelligence.examples.netflux.domain.Movie
import pl.braintelligence.examples.netflux.domain.MovieEvent
import pl.braintelligence.examples.netflux.repositories.MovieRepository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.Duration
import java.util.*

@Service
class MovieServiceImpl(
        val movieRepository: MovieRepository
) : MovieService {

    override fun events(movieId: String): Flux<MovieEvent> {
        return Flux.generate<MovieEvent> { movieEventSynchronousSink ->
            movieEventSynchronousSink.next(MovieEvent(movieId, Date()))
        }.delayElements(Duration.ofSeconds(1))
    }

    override fun getMovieById(id: String): Mono<Movie> {
        return movieRepository.findById(id)
    }

    override fun getAllMovies(): Flux<Movie> {
        return movieRepository.findAll()
    }
}





