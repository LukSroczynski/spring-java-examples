package integration.webflux.quote.application;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import pl.braintelligence.examples.webflux.stock.quote.application.model.Quote;

import static org.assertj.core.api.Java6Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = Quote.class)
public class QuoteApplicationEndpointTest {

    private WebTestClient webTestClient;

    public QuoteApplicationEndpointTest(WebTestClient webTestClient) {
        this.webTestClient = webTestClient;
    }

    public QuoteApplicationEndpointTest() {}

    @Test
    public void testFetchQuotes() {

        webTestClient
                .get()
                .uri("/quotes?size=20")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBodyList(Quote.class)
                .hasSize(21)
                .consumeWith(all_quotes -> {
                    assertThat(all_quotes.getResponseBody())
                            .allSatisfy( quote -> assertThat(quote.getPrice()).isPositive());
                });


    }

}
