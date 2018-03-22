package pl.braintelligence.examples.netflux.bootstrap

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import pl.braintelligence.examples.netflux.domain.Movie
import pl.braintelligence.examples.netflux.repositories.MovieRepository
import reactor.core.publisher.Flux
import java.util.*

@Component
class BootstrapCLR(
        val movieRepository: MovieRepository
) : CommandLineRunner {

    override fun run(vararg args: String?) {

        movieRepository.deleteAll().block()

        Flux.just("Silence of the Lambdas", "AEon Flux", "Enter the Mono<Void>", "The Fluxxinator",
                "Back to the Future", "Meet the Fluxes", "Lord of the Fluxes")
                .map { title -> Movie(title, UUID.randomUUID().toString()) }
                .flatMap { movie -> movieRepository.save(movie) }
                .subscribe(null, null,
                        { movieRepository.findAll().subscribe(System.out::println) })
    }
}
