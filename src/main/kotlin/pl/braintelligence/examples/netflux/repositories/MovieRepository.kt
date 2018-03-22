package pl.braintelligence.examples.netflux.repositories

import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import pl.braintelligence.examples.netflux.domain.Movie

interface MovieRepository : ReactiveMongoRepository<Movie, String>
