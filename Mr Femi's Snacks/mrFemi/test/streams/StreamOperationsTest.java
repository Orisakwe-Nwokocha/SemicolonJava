package streams;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static streams.StreamOperations.getNumbersFormatted;
import static streams.StreamOperations.mapCodePointToCharacter;

public class StreamOperationsTest {

    @Test
    public void testMapCodePointToCharacter() {
        List<Integer> codePoints = List.of(65, 97, 98, 66, 69, 48, 97);
        Map<Integer, String> actual = mapCodePointToCharacter(codePoints);
        Map<Integer, String> expected = Map.of(
                65, "A",
                97, "a",
                98, "b",
                66, "B",
                69, "E",
                48, "0"
        );

        System.out.println(actual);
        assertNotNull(actual);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetNumbersFormatted() {
        List<Integer> numbers = List.of(1,2,2,3,4,4,5,6,7,8,9,10);
        String actual = getNumbersFormatted(numbers);
        String expected = "[1,2,2,3,4,4,5,6,7,8,9,10]";

        System.out.println(actual);

        assertNotNull(actual);
        assertTrue(actual.startsWith("["));
        assertTrue(actual.endsWith("]"));

        assertEquals(expected, actual);

    }
}