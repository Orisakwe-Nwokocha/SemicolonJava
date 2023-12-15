import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConcatenateTwoListsAlternatinglyArrayTest {

    @Test
    public void testConcatenateTwoListsAlternatinglyInt() {
        int[] list1 = {1, 2, 3, 4, 5};
        int[] list2 = {0, -6, 1000, 43, 3};

        int[] concatenatedList = ConcatenateTwoListsAlternatinglyArray.concatenateTwoListsAlternatinglyInt(list1, list2);
        int[] expectedOutput = {1, 0, 2, -6, 3, 1000, 4, 43, 5, 3};

        assertArrayEquals(expectedOutput, concatenatedList);
    }

    @Test
    public void testConcatenateTwoListsAlternatinglyStr() {
        String[] list1 = {"orisha", "mishak", "c19"};
        String[] list2 = {"joseph", "biokes", "c19"};

        String[] concatenatedList = ConcatenateTwoListsAlternatinglyArray.concatenateTwoListsAlternatinglyStr(list1, list2);
        String[] expectedOutput = {"orisha", "joseph", "mishak", "biokes", "c19", "c19"};

        assertArrayEquals(expectedOutput, concatenatedList);
    }
}