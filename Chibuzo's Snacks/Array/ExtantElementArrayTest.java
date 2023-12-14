import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExtantElementArrayTest {
    private ExtantElementArray extantElementArray;

    @BeforeEach
    public void testSetUp() {
        extantElementArray = new ExtantElementArray();
    }

    @Test
    public void testExtantElementInt() {
        int[] numbers = {1, 76, 3, 4, 5};
        int existingNumber = 76;
        int nonExistingNumber = 55;

       boolean isTrue = extantElementArray.extantElement(numbers, existingNumber);
       boolean isFalse = extantElementArray.extantElement(numbers, nonExistingNumber);

        assertTrue(isTrue);
        assertFalse(isFalse);
    }

    @Test
    public void testExtantElementStr() {
        String[] words = {"a", "few", "words"};
        String existingWord = "few";
        String nonExistingWord = "woke";

        boolean isTrue = extantElementArray.extantElement(words, existingWord);
        boolean isFalse = extantElementArray.extantElement(words, nonExistingWord);

        assertTrue(isTrue);
        assertFalse(isFalse);
    }
    @Test
    public void testExtantElementDouble() {
        double[] numbers = {1.0, -7.25, 3.5, 4.0, 5.4};
        double existingNumber = -7.25;
        double nonExistingNumber = 5.42;

        boolean isTrue = extantElementArray.extantElement(numbers, existingNumber);
        boolean isFalse = extantElementArray.extantElement(numbers, nonExistingNumber);

        assertTrue(isTrue);
        assertFalse(isFalse);
    }

    @Test
    public void testExtantElementChar() {
        char[] characters = {'a', '5', '@', '*', ' '};
        char existingCharacter = ' ';
        char nonExistingCharacter = '-';

        boolean isTrue = extantElementArray.extantElement(characters, existingCharacter);
        boolean isFalse = extantElementArray.extantElement(characters, nonExistingCharacter);

        assertTrue(isTrue);
        assertFalse(isFalse);
    }
}