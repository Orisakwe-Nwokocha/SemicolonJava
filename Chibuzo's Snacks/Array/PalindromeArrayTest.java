import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PalindromeArrayTest {
    private PalindromeArray palindromeArray;

    @BeforeEach
    public void testSetup() {
        palindromeArray = new PalindromeArray();
    }

    @Test
    public void testPalindromeCheckerTrue() {
        String[] word = {"saippuakivikauppias"};
        boolean isTrue = palindromeArray.palindromeChecker(word);

        assertEquals(true, isTrue);
    }

    @Test
    public void testPalindromeCheckerSentence() {
        String[] word = {"Was it a car or a cat I saw"};
        boolean isTrue = palindromeArray.palindromeChecker(word);

        assertEquals(true, isTrue);
    }

    @Test
    public void testPalindromeCheckerFalse() {
        String[] word = {"Orisha"};
        boolean isFalse = palindromeArray.palindromeChecker(word);

        assertEquals(false, isFalse);
    }
}