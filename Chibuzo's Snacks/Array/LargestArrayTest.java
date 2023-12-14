import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LargestArrayTest {

    @Test
    public void testLargestElement() {
        LargestArray largestArray = new LargestArray();
        int[] numbers = {1, 76, 3, 4, 5};
        int[] result = largestArray.largestElement(numbers);
        int[] expected = {76};
        assertArrayEquals(expected, result);
    }
}