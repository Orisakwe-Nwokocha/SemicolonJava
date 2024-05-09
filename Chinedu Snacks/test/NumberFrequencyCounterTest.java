package chineduTasks;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static chineduTasks.NumberFrequencyCounter.countFrequencies;
import static org.junit.jupiter.api.Assertions.*;

public class NumberFrequencyCounterTest {

    @Test
    public void testCountFrequencies() {
        int[] numbers = {1, 2, 2, 1, 3, 1};
        Map<String, Integer> expected = new HashMap<>();
        expected.put("1", 3);
        expected.put("2", 2);
        expected.put("3", 1);

        assertEquals(expected, countFrequencies(numbers));
    }
}