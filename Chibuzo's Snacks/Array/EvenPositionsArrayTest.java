import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EvenPositionsArrayTest {

    @Test
    public void testEvenPositions() {
        int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        int[] evenPositionsArray = EvenPositionsArray.evenPositions(numbers);
        int[] expected = {1, 3, 5, 7};

        assertArrayEquals(expected, evenPositionsArray);
    }
}