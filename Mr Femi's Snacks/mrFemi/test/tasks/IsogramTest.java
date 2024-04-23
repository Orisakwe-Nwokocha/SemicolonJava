package mrFemi.tasks;

import org.junit.jupiter.api.Test;

import static mrFemi.tasks.Isogram.isIsogram;
import static org.junit.jupiter.api.Assertions.*;

public class IsogramTest {

    @Test
    public void isIsogramTest() {
        String text = "The quick brown fox jumps over the lazy dog";
        assertTrue(isIsogram(text));
    }

    @Test
    public void isIsogramTest2() {
        String text = "2The quick brown2 fox jumps over the lazy dog2";
        assertTrue(isIsogram(text));
    }
}