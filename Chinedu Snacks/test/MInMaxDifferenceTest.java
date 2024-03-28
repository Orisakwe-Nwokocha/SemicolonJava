package chineduTasks;

import org.junit.jupiter.api.Test;

import static chineduTasks.MInMaxDifference.findMinMaxDifferenceOf;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class MInMaxDifferenceTest {
    @Test
    public void testDifferenceOfMinMax1() {
        int[] numbers = { 2, 4, 5, 7, 8};
        assertArrayEquals(new int[]{6}, findMinMaxDifferenceOf(numbers));
    }
    @Test
    public void testDifferenceOfMinMax2() {
        int[] numbers = { 2, 1, 3, 4, 9};
        assertArrayEquals(new int[]{8}, findMinMaxDifferenceOf(numbers));
    }
}
