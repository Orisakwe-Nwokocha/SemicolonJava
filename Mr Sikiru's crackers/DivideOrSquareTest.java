import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DivideOrSquareTest {

    @Test
    public void testDivideOrSquareSqrt() {
        double actual = DivideOrSquare.divideOrSquare(10);
        assertEquals(3.1622776601683795, actual);
    }

    @Test
    public void testDivideOrSquareRemainder() {
        double actual = DivideOrSquare.divideOrSquare(48);
        assertEquals(3, actual);
    }
}