import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ReverseArrayTest {

    @Test
    public void testReverseList() {
        ReverseArray reverseArray = new ReverseArray();
        int[] numbers = {1, 2, 3, 4, 5};
        int[] numbersInReverse = reverseArray.reverseList(numbers);
        int[] expected = {5, 4, 3, 2, 1};

        assertArrayEquals(expected, numbersInReverse);
    }
}