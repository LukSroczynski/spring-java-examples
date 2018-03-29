package pl.braintelligence.examples.webflux.stock.quote.application.service;

import pl.braintelligence.examples.webflux.stock.quote.application.model.Quote;
import reactor.core.publisher.Flux;

import java.time.Duration;

public interface QuoteGeneratorService {
    Flux<Quote> fetchQuoteStream(Duration period);
}
