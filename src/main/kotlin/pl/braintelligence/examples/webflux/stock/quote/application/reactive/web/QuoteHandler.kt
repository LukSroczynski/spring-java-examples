package pl.braintelligence.examples.webflux.stock.quote.application.reactive.web

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.HandlerFunction
import org.springframework.web.reactive.function.server.RequestPredicates.GET
import org.springframework.web.reactive.function.server.RequestPredicates.accept
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.RouterFunctions
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import pl.braintelligence.examples.webflux.stock.quote.application.model.Quote
import pl.braintelligence.examples.webflux.stock.quote.application.service.QuoteGeneratorService
import reactor.core.publisher.Mono
import java.time.Duration

@Component
class QuoteHandler(
        val quoteGeneratorService: QuoteGeneratorService
) {
    fun fetchQuotes(serverRequest: ServerRequest): Mono<ServerResponse> {
        val size: Long = serverRequest.queryParam("size").orElse("10").toLong()

        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(quoteGeneratorService.fetchQuoteStream(Duration.ofMillis(1000))
                        .take(size), Quote::class.java)
    }

    fun streamQuotes(serverRequest: ServerRequest): Mono<ServerResponse> {
        return ok().contentType(MediaType.APPLICATION_STREAM_JSON)
                .body(this.quoteGeneratorService.fetchQuoteStream(Duration.ofMillis(200)), Quote::class.java)
    }
}

@Configuration
class QuoteRouter {

    @Bean
    fun route(handler: QuoteHandler): RouterFunction<ServerResponse> {

        return RouterFunctions
                .route(GET("/quotes").and(accept(MediaType.APPLICATION_JSON)), HandlerFunction<ServerResponse> { handler.fetchQuotes(it) })
                .andRoute(GET("/quotes").and(accept(MediaType.APPLICATION_JSON)), HandlerFunction<ServerResponse> { handler.streamQuotes(it) })
    }
}