import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConcatenateTwoListsArrayTest {

    @Test
    public void testConcatenateTwoListsInt() {
        int[] list1 = {1, 2, 3, 4, 5};
        int[] list2 = {0, -6, 1000, 43};

        int[] concatenatedList = ConcatenateTwoListsArray.concatenateTwoListsInt(list1, list2);
        int[] expectedOutput = {1, 2, 3, 4, 5, 0, -6, 1000, 43};

        assertArrayEquals(expectedOutput, concatenatedList);
    }
    @Test
    public void testConcatenateTwoListsStr() {
        String[] list1 = {"orisha", "mishak", "chichi", "marvelous", "femi", "c19"};
        String[] list2 = {"joseph", "biokes", "victor", "aramide", "c19"};

        String[] concatenatedList = ConcatenateTwoListsArray.concatenateTwoListsStr(list1, list2);
        String[] expectedOutput = {"orisha", "mishak", "chichi", "marvelous", "femi", "c19", "joseph", "biokes", "victor", "aramide", "c19"};

        assertArrayEquals(expectedOutput, concatenatedList);
    }
}