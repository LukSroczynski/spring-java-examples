package pl.braintelligence.examples.json.reader.books;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Books {

    private final List<Items> items;

    @JsonCreator
    public Books(
            @JsonProperty("items") List<Items> items
    ) {
        this.items = items;
    }

    public List<Items> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "Books{" +
                "items=" + items +
                '}';
    }
}
