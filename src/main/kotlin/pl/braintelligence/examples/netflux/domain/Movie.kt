package pl.braintelligence.examples.netflux.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document
data class Movie(
        @Id val id: String,
        val title: String
)

data class MovieEvent(
        val id: String,
        val date: Date
)