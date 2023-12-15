import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class OddPositionsArrayTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Test
    public void testOddPositions() {
        int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8};


        String expectedOutput = "0 2 4 6 8 ";
        System.setOut(new PrintStream(outputStreamCaptor));

        OddPositionsArray.oddPositions(numbers);

        assertEquals(expectedOutput, outputStreamCaptor.toString());


    }
}