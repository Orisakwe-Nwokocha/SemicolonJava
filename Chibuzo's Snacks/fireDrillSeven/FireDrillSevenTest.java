package fireDrillSeven;

import fireDrillSix.FireDrillSix;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FireDrillSevenTest {

    @Test
    public void givenArrayOfNumbers_whenModified_returnsArrayOfTrueAndFalse() {
        int[] sampleInput = {4, 5, 8, 8, 8, 2, 9};
        boolean[] expected = {false, true, false, false, false, false, true};

        assertArrayEquals(expected, FireDrillSeven.returnBoolean(sampleInput));
    }

}