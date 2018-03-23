package java8.streams

import junit.framework.TestCase.assertEquals
import org.junit.Test
import java.util.*

class FunctionalProgrammingKotlinTest {

    @Test
    fun countWordsWithSixCharacters() {

        val dogs = Arrays.asList("XX", "123456", "XYZXYZ", "qwerty", "1234", "12345")

        val dogsCounter = dogs
                .filter { dog -> dog.length == 6 }
                .size

        assertEquals(dogsCounter, 3)
    }

    @Test
    fun listInternalIterLambdaMethodTypeJava8MethodRef() {
        val dogs = Arrays.asList("Vizsla", "Lab", "Golden", "GSP", "Poodle", "Yorkie", "Mutt")

        dogs.forEach( { println(it) } )
    }

}