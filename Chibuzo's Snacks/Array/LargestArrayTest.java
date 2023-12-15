import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LargestArrayTest {

    @Test
    public void testLargestElementArray() {
        LargestArray largestArray = new LargestArray();
        int[] numbers = {1, 76, 3, 4, 5};
        int[] result = largestArray.largestElementArray(numbers);
        int[] expected = {76};
        assertArrayEquals(expected, result);
    }

    @Test
    public void testLargestElement() {
        int[] numbers = {0, -6, 1000, 2575, 43};
        int result = LargestArray.largestElement(numbers);

        assertEquals(2575, result);
    }
}