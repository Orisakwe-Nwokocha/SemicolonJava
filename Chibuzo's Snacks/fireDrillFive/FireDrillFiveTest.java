package fireDrillFive;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FireDrillFiveTest {


    @Test
    public void takeArray_doubleItsLength_returnTheModifiedArrayTest() {
        int[] sampleArray = {4, 5, 8};
        assertEquals(3, sampleArray.length);

        assertEquals(6, FireDrillFive.doubleTheLengthOf(sampleArray).length);
    }

    @Test
    public void takeArray_arrayLengthIsDoubled_theDuplicatedElementsAreDoubledTest() {
        int[] sampleArray = {4, 5, 8};
        assertEquals(3, sampleArray.length);
        assertEquals(6, FireDrillFive.doubleTheLengthOf(sampleArray).length);

        int[] expected = {4, 5, 8, 8, 10, 16};

        assertArrayEquals(expected, FireDrillFive.populateAndDoubleTheDuplicatedElementsOf(sampleArray));
    }
}
