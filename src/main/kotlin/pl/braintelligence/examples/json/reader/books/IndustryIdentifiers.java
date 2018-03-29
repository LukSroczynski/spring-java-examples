package pl.braintelligence.examples.json.reader.books;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class  IndustryIdentifiers {

    private final String identifier;
    private final String type;

    @JsonCreator
    public IndustryIdentifiers(
            @JsonProperty("identifier") String identifier,
            @JsonProperty("type") String type) {
        this.identifier = identifier;
        this.type = type;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getType() {
        return type;
    }
}
