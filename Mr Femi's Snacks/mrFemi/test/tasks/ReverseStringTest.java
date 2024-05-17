package mrFemi.tasks;

import org.junit.jupiter.api.Test;

import static mrFemi.tasks.ReverseString.reverse;
import static mrFemi.tasks.ReverseString.reverseWithCustomSplit;
import static org.junit.jupiter.api.Assertions.*;

public class ReverseStringTest {

    @Test
    public void testReverse() {
        String string = "It is still a beautiful world";
        assertEquals("world beautiful a still is It", reverse(string));
    }

    @Test
    public void testReverse2() {
        String string = "It is still a beautiful world";
        assertEquals("world beautiful a still is It", reverseWithCustomSplit(string));
    }

    @Test
    public void testReverse3() {
        String string = "   ";
        assertThrows(IllegalArgumentException.class, () -> reverse(string));
        assertThrows(IllegalArgumentException.class, () -> reverseWithCustomSplit(string));
    }
}