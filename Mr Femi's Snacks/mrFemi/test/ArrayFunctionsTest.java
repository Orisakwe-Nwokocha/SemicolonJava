package mrFemi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayFunctionsTest {
    @Test
    public void testMaximumProduct() {
        int[] numbers = {1, 3, 2, 5, 10, 4};
        int expected = 50;
        assertEquals(expected, ArrayFunctions.findTheMaxProductOf(numbers));
        assertEquals(20, ArrayFunctions.findTheMaxProductOf(new int[]{-1, -3, -2, -4, -5}));
    }

    @Test
    public void testArrangeArrayElements() {
        int[] numbers = {3, 2, 0, -1, 7, 0, 8};
        int[] expected = {3, 2, -1, 7, 8, 0, 0};

        assertArrayEquals(expected, ArrayFunctions.sort(numbers));
    }
}
