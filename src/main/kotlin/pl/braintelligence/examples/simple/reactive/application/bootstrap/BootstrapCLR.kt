package pl.braintelligence.examples.simple.reactive.application.bootstrap

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import pl.braintelligence.examples.simple.reactive.application.domain.Movie
import pl.braintelligence.examples.simple.reactive.application.repositories.MovieRepository
import reactor.core.publisher.Flux
import java.util.*

@Component
class BootstrapCLR(
        val movieRepository: MovieRepository
) : CommandLineRunner {

    override fun run(vararg args: String?) {

        movieRepository.deleteAll().block()

        Flux.just("Ojciec Chrzestny", "Nietykalni", "Władca Pierścieni", "Django", "Incepcja")
                .map { Movie(title = it, id = UUID.randomUUID().toString()) }
                .map{ movieRepository.save(it).then() }
                .subscribe(null, null, { movieRepository.findAll().subscribe(System.out::println) })
    }
}