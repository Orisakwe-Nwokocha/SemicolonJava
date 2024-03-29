package minMax;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MinMaxTest {
    @Test
    public void testMinMax() {
        int[] numbers = {3, 4, 2, 5, 1};

        assertArrayEquals(new int[]{10, 14}, MinMax.firstTry(numbers));
    }

    @Test
    public void testMinMaxSecondTry() {
        int[] numbers = {3, 1, 2, 4, 5};

        assertArrayEquals(new int[]{10, 14}, MinMax.secondTry(numbers));
    }

}