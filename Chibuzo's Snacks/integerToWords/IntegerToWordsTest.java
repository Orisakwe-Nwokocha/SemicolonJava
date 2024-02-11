package integerToWords;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class IntegerToWordsTest {

    @Test
    public void hourInIntegerIsInputted_returnsHourInWordsTest() {
        assertEquals("Eleven", IntegerToWords.getHourInWords(11));
    }


    @Test
    public void minuteInIntegerIsInputted_returnsMinuteInWordsTest() {
        assertEquals("Forty Five", IntegerToWords.getMinuteInWords(45));
    }

    @Test
    public void inputTimeInInteger_returnsTimeInWordsTest() {
        assertEquals("Fourteen minutes to One", IntegerToWords.displayTimeInWords(12, 46));
        assertEquals("Eight minutes past Eleven", IntegerToWords.displayTimeInWords(23, 8));
        assertEquals("quarter to One", IntegerToWords.displayTimeInWords(0, 45));
        assertEquals("Three minutes to Three", IntegerToWords.displayTimeInWords(14, 57));
    }

    @Test
    public void inputInvalidTime_throwsExceptionTest() {
        assertThrows(IllegalArgumentException.class, ()->IntegerToWords.displayTimeInWords(24, -1));
        assertThrows(IllegalArgumentException.class, ()->IntegerToWords.displayTimeInWords(-1, 60));
        assertThrows(IllegalArgumentException.class, ()->IntegerToWords.displayTimeInWords(11, 78));
        assertThrows(IllegalArgumentException.class, ()->IntegerToWords.displayTimeInWords(37, 30));
    }
}
