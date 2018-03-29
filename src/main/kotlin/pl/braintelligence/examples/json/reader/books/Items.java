package pl.braintelligence.examples.json.reader.books;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Items {

    private final String id;
    private final VolumeInfo volumeInfo;


    @JsonCreator
    public Items(
            @JsonProperty("id") String id,
            @JsonProperty("volumeInfo") VolumeInfo volumeInfo
    ) {
        this.id = id;
        this.volumeInfo = volumeInfo;
    }

    public String getId() {
        return id;
    }

    public VolumeInfo getVolumeInfo() {
        return volumeInfo;
    }

    @Override
    public String toString() {
        return "Items{" +
                "id='" + id + '\'' +
                ", volumeInfo=" + volumeInfo +
                '}';
    }
}
