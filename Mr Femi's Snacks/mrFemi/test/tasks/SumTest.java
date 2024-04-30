package mrFemi.tasks;

import org.junit.jupiter.api.Test;

import static mrFemi.tasks.Sum.add;
import static mrFemi.tasks.Sum.add2;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumTest {

    @Test
    public void testSum() {
        int firstNumber = 35;
        int secondNumber = 76;
        assertEquals(111, add(firstNumber, secondNumber));
    }

    @Test
    public void testSum2() {
        int firstNumber = -35;
        int secondNumber = -2;
        assertEquals(-37, add2(firstNumber, secondNumber));
    }

    @Test
    public void testSum3() {
        int firstNumber = -35;
        int secondNumber = 2;
        assertEquals(-33, add2(firstNumber, secondNumber));
    }

    @Test
    public void testSum4() {
        int firstNumber = 2;
        int secondNumber = -35;
        assertEquals(-33, add2(firstNumber, secondNumber));
    }
}
