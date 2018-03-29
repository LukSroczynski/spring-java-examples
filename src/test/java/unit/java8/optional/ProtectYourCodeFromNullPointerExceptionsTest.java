package unit.java8.optional;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 *
 *  Source: http://www.baeldung.com/java-optional
 *
 */

public class ProtectYourCodeFromNullPointerExceptionsTest {

    @Test
    public void whenCreatesEmptyOptional_thenCorrect() {
        Optional<String> empty = Optional.empty();
        assertFalse(empty.isPresent());
    }

    @Test
    public void givenNonNull_whenCreatesNonNullable_thenCorrect() {
        String name = "test";
        Optional.of(name);
    }

    @Test
    public void givenNonNull_whenCreatesOptional_thenCorrect() {
        String name = "test";
        Optional<String> opt = Optional.of(name);
        assertEquals("Optional[test]", opt.toString());
    }

    // However, the argument passed to the of method cannot be null, otherwise, we will get a NullPointerException
    @Test(expected = NullPointerException.class)
    public void givenNull_whenThrowsErrorOnCreate_thenCorrect() {
        String name = null;
        Optional<String> opt = Optional.of(name);
    }

    //But, in case we expect some null values for the passed in argument, we can use the ofNullable API:
    @Test
    public void givenNonNull_whenCreatesNullable_thenCorrect() {
        String name = "baeldung";
        Optional<String> opt = Optional.ofNullable(name);
        assertEquals("Optional[baeldung]", opt.toString());
    }

    @Test
    public void givenNull_whenCreatesNullable_thenCorrect() {
        String name = null;
        Optional<String> opt = Optional.ofNullable(name);
        assertEquals("Optional.empty", opt.toString());
    }


}