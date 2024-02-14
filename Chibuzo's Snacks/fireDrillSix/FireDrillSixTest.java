package fireDrillSix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class FireDrillSixTest {

    @Test
    public void givenArrayOfNumbers_whenModified_returns1sAnd0s() {
        int[] sampleInput = {4, 5, 8, 8, 8, 2, 9};
        int[] expected = {0, 1, 0, 0, 0, 0, 1};

        assertArrayEquals(expected, FireDrillSix.modifyIntegers(sampleInput));
    }
}
