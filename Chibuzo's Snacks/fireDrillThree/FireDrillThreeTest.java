import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FireDrillThreeTest {

    @Test
    public void taskOneCanStore10ScoresInAnArrayTest() {
        int[] scoresArray = FireDrillThree.taskOne(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        assertArrayEquals(expected, scoresArray);
    }

    @Test
    public void taskTwoPrintScoresVertically_fromScoresInTaskOneTest() {
        String printScoresVertically = FireDrillThree.taskTwo();
        String expected = "1\n2\n3\n4\n5\n6\n7\n8\n9\n10\n";

        assertEquals(expected, printScoresVertically);
    }

    @Test
    public void taskThreePrintScoresHorizontally_fromScoresInTaskOneTest() {
        String printScoresVertically = FireDrillThree.taskThree();
        String expected = "1 2 3 4 5 6 7 8 9 10 ";

        assertEquals(expected, printScoresVertically);
    }

    @Test
    public void taskFourStoresOnlyElementsAtEvenIndexesInNewArray_fromCollectedArrayOfOddArrayLength() {
        int[] numbers = {4, 7, 9, 2, 1, 85, 67, 35, 8};
        int[] elementsAtOddIndexes = FireDrillThree.taskFour(numbers);

        int[] expected = {4, 9, 1, 67, 8};

        assertArrayEquals(expected, elementsAtOddIndexes);
    }

    @Test
    public void taskFourStoresOnlyElementsAtEvenIndexesInNewArray_fromCollectedArrayOfEvenArrayLength() {
        int[] numbers = {4, 7, 9, 2, 1, 85, 67, 35};
        int[] elementsAtOddIndexes = FireDrillThree.taskFour(numbers);

        int[] expected = {4, 9, 1, 67};

        assertArrayEquals(expected, elementsAtOddIndexes);
    }

    @Test
    public void taskFiveStoresOnlyElementsAtOddIndexesInNewArray_fromCollectedArrayTest() {
        int[] numbers = {4, 7, 9, 2, 1, 85, 67, 35};
        int[] elementsAtEvenIndexes = FireDrillThree.taskFive(numbers);

        int[] expected = {7, 2, 85, 35};

        assertArrayEquals(expected, elementsAtEvenIndexes);
    }

    @Test
    public void taskSixCalculatesSumOfTaskFourOutputTest() {
        int actual = FireDrillThree.taskSix(new int[] {4, 7, 9, 2, 1, 85, 67, 35});

        assertEquals(81, actual);
    }

    @Test
    public void taskSevenCalculatesSumOfTaskFiveOutputTest() {
        int actual = FireDrillThree.taskSeven(new int[] {4, 7, 9, 2, 1, 85, 67, 35});

        assertEquals(129, actual);
    }

    @Test
    public void taskEightOutputsMinimumOfTaskFourTest() {
        int actual = FireDrillThree.taskEight(new int[] {4, 7, 9, 2, 1, 85, 67, 35});

        assertEquals(1, actual);
    }

    @Test
    public void taskNineOutputsMinimumOfTaskFourTest() {
        int actual = FireDrillThree.taskNine(new int[] {4, 7, 9, 2, 1, 85, 67, 35});

        assertEquals(2, actual);
    }

    @Test
    public void taskTenOutputsMaximumOfTaskFourTest() {
        int actual = FireDrillThree.taskTen(new int[] {4, 7, 9, 2, 1, 85, 67, 35});

        assertEquals(67, actual);
    }

    @Test
    public void taskElevenOutputsMaximumOfTaskFourTest() {
        int actual = FireDrillThree.taskEleven(new int[] {4, 7, 9, 2, 1, 85, 67, 35});

        assertEquals(85, actual);
    }

    @Test
    public void taskTwelveCanSwapElementsInOddAndEvenIndicesTest() {
        int[] actual = FireDrillThree.taskTwelve(new int[] {4, 7, 9, 2, 1, 85, 67, 35});

        int[] expected = {7, 4, 2, 9, 85, 1, 35, 67};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void taskThirteen_dontSwapIfAnyOfThePairIsEvenTest() {
        int[] actual = FireDrillThree.taskThirteen(new int[] {4, 7, 9, 2, 1, 85, 67, 35});

        int[] expected = {4, 7, 9, 2, 85, 1, 35, 67};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void taskFourteen_dontSwapIfAnyOfThePairIsOddTest() {
        int[] actual = FireDrillThree.taskFourteen(new int[] {4, 7, 9, 2, 8, 10, 1, 85, 67, 35});

        int[] expected = {4, 7, 9, 2, 10, 8, 1, 85, 67, 35};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void taskFifteen_dontSwapIfBothOfThePairAreOddTest() {
        int[] actual = FireDrillThree.taskFifteen(new int[] {4, 7, 9, 2, 8, 10, 1, 85, 67, 35});

        int[] expected = {7, 4, 2, 9, 10, 8, 1, 85, 67, 35};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void taskSixteen_dontSwapIfBothOfThePairAreEvenTest() {
        int[] actual = FireDrillThree.taskSixteen(new int[] {4, 7, 9, 2, 8, 10, 1, 85, 67, 35});

        int[] expected = {7, 4, 2, 9, 8, 10, 85, 1, 35, 67};

        assertArrayEquals(expected, actual);
    }
}