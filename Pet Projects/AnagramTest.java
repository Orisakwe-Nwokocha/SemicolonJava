import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AnagramTest {

    @Test
    public void isAnagramSentenceTrue() {
        assertTrue(Anagram.isAnagram("New York Times", "monkeys write"));
    }
    @Test
    public void isAnagramSentenceFalse() {
        assertFalse(Anagram.isAnagram("I am a boy", "aim a by"));
    }

    @Test
    public void isAnagramTrue() {
        assertTrue(Anagram.isAnagram("Silent", "liSTeN"));
    }
    @Test
    public void isAnagramFalse() {
        assertFalse(Anagram.isAnagram("Orisha", "Orisa"));
    }

}