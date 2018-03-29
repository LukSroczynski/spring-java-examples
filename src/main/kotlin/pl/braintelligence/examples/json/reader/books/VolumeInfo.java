package pl.braintelligence.examples.json.reader.books;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VolumeInfo {

    private final String title;
    private final List<IndustryIdentifiers> industryIdentifiers;

    @JsonCreator
    public VolumeInfo(
            @JsonProperty("title") String title,
            @JsonProperty("industryIdentifiers") List<IndustryIdentifiers> industryIdentifiers
    ) {
        this.title = title;
        this.industryIdentifiers = industryIdentifiers;
    }

    public List<IndustryIdentifiers> getIndustryIdentifiers() {
        return industryIdentifiers;
    }


    public String getTitle() {
        return title;
    }
}
