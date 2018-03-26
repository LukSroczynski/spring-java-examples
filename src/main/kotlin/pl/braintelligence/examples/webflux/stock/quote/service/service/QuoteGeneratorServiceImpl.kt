package pl.braintelligence.examples.webflux.stock.quote.service.service

import org.springframework.stereotype.Service
import pl.braintelligence.examples.webflux.stock.quote.service.model.Quote
import reactor.core.publisher.Flux
import java.math.BigDecimal
import java.math.MathContext
import java.time.Duration
import java.time.Instant
import java.util.*
import java.util.stream.Collectors
import kotlin.collections.ArrayList





interface QuoteGeneratorService {
    fun fetchQuoteService(duration: Duration): Flux<Quote>
}

@Service
class QuoteGeneratorServiceImpl(
        val instant: Instant = Instant.now()
) : QuoteGeneratorService {

    private val random = Random()
    private val mathContext = MathContext(2)
    private val prices: List<Quote> = ArrayList<Quote>()


    override fun fetchQuoteService(period: Duration): Flux<Quote> {
        return Flux.interval(period)
                .onBackpressureDrop()
                .map(this::generateQuotes)
                .flatMapIterable { quotes -> quotes }
                .log("pl.braintelligence.examples.webflux.stock.quote.service.service")
    }

    private fun generateQuotes(interval: Long): List<Quote> {
        return prices.stream()
                .map { baseQuote ->
                    val priceChange = baseQuote.price
                            .multiply(BigDecimal(0.05 * this.random.nextDouble()), this.mathContext)
                    val result = Quote(baseQuote.ticker, baseQuote.price.add(priceChange))
                    result
                }
                .collect(Collectors.toList<Quote>())
    }

}
