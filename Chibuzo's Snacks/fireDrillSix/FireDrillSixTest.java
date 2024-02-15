package fireDrillSix;

import geoPoliticalZone.FindGeoZone;
import geoPoliticalZone.GeoPoliticalZone;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FireDrillSixTest {

    @Test
    public void givenArrayOfNumbers_whenModified_returns1sAnd0s() {
        int[] sampleInput = {4, 5, 8, 8, 8, 2, 9};
        int[] expected = {0, 1, 0, 0, 0, 0, 1};

        assertArrayEquals(expected, FireDrillSix.modifyIntegers(sampleInput));
    }

    @Test
    public void givenArrayOfNumbers_whenModified_returnsArrayOfTrueAndFalse() {
        int[] sampleInput = {4, 5, 8, 8, 8, 2, 9};
        boolean[] expected = {false, true, false, false, false, false, true};

        assertArrayEquals(expected, FireDrillSix.returnBoolean(sampleInput));
    }

    @Test
    public void givenArrayOfNumbers_whenModified_returnsTenZeros() {
        int[] expected = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        assertArrayEquals(expected, FireDrillSix.returnInteger());
    }

}
