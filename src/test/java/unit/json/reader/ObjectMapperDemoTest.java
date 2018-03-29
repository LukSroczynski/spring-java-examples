package unit.json.reader;

import org.junit.Before;
import org.junit.Test;
import pl.braintelligence.examples.json.reader.books.Books;
import pl.braintelligence.examples.json.reader.books.Items;
import pl.braintelligence.examples.json.reader.books.VolumeInfo;
import pl.braintelligence.examples.json.reader.utils.ObjectMapperDemo;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ObjectMapperDemoTest {

    private Books books;

    @Before
    public void setup() throws Exception {
        ObjectMapperDemo objectMapperDemo = new ObjectMapperDemo();
        books = objectMapperDemo.readJsonWithObjectMapper();
    }

    @Test
    public void showAllIdentifiers() throws Exception {

        List<Items> items = books.getItems();
        String expectedIdentifier = "9781592432172";

        List<Items> result = getValidItems(items, expectedIdentifier);

    }

    private static List<Items> getValidItems(List<Items> items, String expectedIdentifier) {
        return items.stream()
                .filter(s -> isValid(Collections.singletonList(s.getVolumeInfo()), expectedIdentifier) )
                .collect(Collectors.toList());
    }

    private static boolean isValid(List<VolumeInfo> volumeInfos, String expectedIdentifier) {
        return volumeInfos.stream()
                .map(VolumeInfo::getIndustryIdentifiers)
                .flatMap(Collection::stream)
                .distinct()
                .collect(Collectors.toList())
                .stream()
                .anyMatch( s -> s.getIdentifier().equals(expectedIdentifier) );

    }

}