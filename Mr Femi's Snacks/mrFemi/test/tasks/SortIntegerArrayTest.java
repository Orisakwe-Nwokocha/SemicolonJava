package mrFemi.tasks;

import org.junit.jupiter.api.Test;

import static mrFemi.tasks.SortIntegerArray.sort;
import static mrFemi.tasks.SortIntegerArray.sortReverse;
import static org.junit.jupiter.api.Assertions.*;

public class SortIntegerArrayTest {

    @Test
    public void testSort() {
        int[] numbers = {10, 8, 5, 4, 9};
        int[] expected = {5, 3, 2, 1, 4};
        assertArrayEquals(expected, sort(numbers));
    }

    @Test
    public void testSortReverse() {
        int[] numbers = {10, 8, 5, 6, 9};
        int[] expected = {1, 3, 5, 4, 2};
        assertArrayEquals(expected, sortReverse(numbers));
    }
}