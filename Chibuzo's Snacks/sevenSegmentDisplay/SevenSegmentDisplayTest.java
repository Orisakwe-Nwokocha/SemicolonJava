package sevenSegmentDisplay;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sevenSegmentDisplay.exceptions.NonBinaryNumberException;
import sevenSegmentDisplay.exceptions.NonDigitNumberException;

import static org.junit.jupiter.api.Assertions.*;

public class SevenSegmentDisplayTest {
    private static SevenSegmentDisplay display;

    @BeforeEach
    public void initializeDisplay() {
        display = new SevenSegmentDisplay();
    }

    @Test
    public void userInputsNonDigitNumbers_throwsNonDigitNumberExceptionTest() {
        assertThrows(NonDigitNumberException.class, () -> display.displaySegment("1234s678"));
    }

    @Test
    public void userInputsNonBinaryDigitNumbers_throwsNonBinaryNumberExceptionTest() {
        assertThrows(NonBinaryNumberException.class, () -> display.displaySegment("12345678"));
    }

   @Test
    public void userInputsMoreThan8DigitNumbers_throwsIllegalArgumentExceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> display.displaySegment("010011101"));
    }

    @Test
    public void userInputsLessThan8DigitNumbers_throwsIllegalArgumentExceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> display.displaySegment("1110001"));
    }

    @Test
    public void given11111100_boardIsOffTest() {
        display.displaySegment("11111100");
        assertFalse(display.isOn());
    }

    @Test
    public void given11111101_boardIsOnTest() {
        display.displaySegment("11111101");
        assertTrue(display.isOn());
    }

    @Test
    public void given11111100_IsOff_thenEmptyStringIsDisplayedTest() {
        assertFalse(display.isOn());
        assertEquals("", display.displaySegment("11111100"));
    }

    @Test
    public void given11111101_boardIsOn_whenDisplayed_thenHashtagsRepresenting0IsDisplayedTest() {
        String actual = display.displaySegment("11111101");
        assertTrue(display.isOn());
        String expected = """
                # # # #
                #     #
                #     #
                #     #
                # # # #
                """;
        assertEquals(expected, actual);
    }

    @Test
    public void given01100001_boardIsOn_whenDisplayed_thenHashtagsRepresenting1IsDisplayedTest() {
        String actual = display.displaySegment("01100001");
        assertTrue(display.isOn());
        String expected = """
                      #
                      #
                      #
                      #
                      #
                """;
        assertEquals(expected, actual);
        System.out.println(actual);
    }
    @Test
    public void given01100001_boardIsOn_whenDisplayed_thenHashtagsRepresenting2IsDisplayedTest() {
        String actual = display.displaySegment("11011011");
        assertTrue(display.isOn());
        String expected = """
                # # # #
                      #
                # # # #
                #
                # # # #
                """;
        assertEquals(expected, actual);
        System.out.println(actual);
    }
    @Test
    public void given01100001_boardIsOn_whenDisplayed_thenHashtagsRepresenting3IsDisplayedTest() {
        String actual = display.displaySegment("11110011");
        assertTrue(display.isOn());
        String expected = """
                      #
                      #
                      #
                      #
                      #
                """;
        assertEquals(expected, actual);
        System.out.println(actual);
    }
    @Test
    public void given01100001_boardIsOn_whenDisplayed_thenHashtagsRepresenting4IsDisplayedTest() {
        String actual = display.displaySegment("01100111");
        assertTrue(display.isOn());
        String expected = """
                      #
                      #
                      #
                      #
                      #
                """;
        assertEquals(expected, actual);
        System.out.println(actual);
    }
    @Test
    public void given01100001_boardIsOn_whenDisplayed_thenHashtagsRepresenting5IsDisplayedTest() {
        String actual = display.displaySegment("10110111");
        assertTrue(display.isOn());
        String expected = """
                      #
                      #
                      #
                      #
                      #
                """;
        assertEquals(expected, actual);
        System.out.println(actual);
    }
    @Test
    public void given01100001_boardIsOn_whenDisplayed_thenHashtagsRepresenting6IsDisplayedTest() {
        String actual = display.displaySegment("10111111");
        assertTrue(display.isOn());
        String expected = """
                      #
                      #
                      #
                      #
                      #
                """;
        assertEquals(expected, actual);
        System.out.println(actual);
    }
    @Test
    public void given01100001_boardIsOn_whenDisplayed_thenHashtagsRepresenting7IsDisplayedTest() {
        String actual = display.displaySegment("11100001");
        assertTrue(display.isOn());
        String expected = """
                      #
                      #
                      #
                      #
                      #
                """;
        assertEquals(expected, actual);
        System.out.println(actual);
    }
    @Test
    public void given01100001_boardIsOn_whenDisplayed_thenHashtagsRepresenting8IsDisplayedTest() {
        String actual = display.displaySegment("11111111");
        assertTrue(display.isOn());
        String expected = """
                      #
                      #
                      #
                      #
                      #
                """;
        assertEquals(expected, actual);
        System.out.println(actual);
    }
    @Test
    public void given01100001_boardIsOn_whenDisplayed_thenHashtagsRepresenting9IsDisplayedTest() {
        String actual = display.displaySegment("11110111");
        assertTrue(display.isOn());
        String expected = """
                      #
                      #
                      #
                      #
                      #
                """;
        assertEquals(expected, actual);
        System.out.println(actual);
    }

}