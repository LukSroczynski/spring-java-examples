package pl.braintelligence.examples.json.reader.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import pl.braintelligence.examples.json.reader.books.Books;

import java.io.File;
import java.io.IOException;

public class ObjectMapperDemo {

    public Books readJsonWithObjectMapper() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File("books.json"), Books.class);
    }

}
