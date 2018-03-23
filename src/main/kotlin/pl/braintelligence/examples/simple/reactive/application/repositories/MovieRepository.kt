package pl.braintelligence.examples.simple.reactive.application.repositories

import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import pl.braintelligence.examples.simple.reactive.application.domain.Movie

interface MovieRepository : ReactiveMongoRepository<Movie, String>