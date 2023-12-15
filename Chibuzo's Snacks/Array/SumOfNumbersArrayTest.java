import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SumOfNumbersArrayTest {

    @Test
    public void testSumOfNumbersForLoop() {
        int[] numbersToSum = {9, 0, 7, 8, 9, 7, 6, 3, 4, 5};
        int numbersSummed = SumOfNumbersArray.sumOfNumbersForLoop(numbersToSum);

        assertEquals(58, numbersSummed);

    }

    @Test
    public void testSumOfNumbersWhileLoop() {
        int[] numbersToSum = {3, 0, -5, 8, 9, -8, 6, -2, 4, 5};
        int numbersSummed = SumOfNumbersArray.sumOfNumbersWhileLoop(numbersToSum);

        assertEquals(20, numbersSummed);

    }

    @Test
    public void testSumOfNumbersD0WhileLoop() {
        int[] numbersToSum = {10, 2, 35, 4, 5};
        int numbersSummed = SumOfNumbersArray.sumOfNumbersDoWhileLoop(numbersToSum);

        assertEquals(56, numbersSummed);

    }
}