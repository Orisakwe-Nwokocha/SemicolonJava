import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ZereodCodeArrayTest {

    @Test
    public void testZeroedCode() {
        int[] array = {2, 5, 7, 8, 9};
        int[] actual = ZereodCodeArray.zeroedCode(array);
        int[] expected = {0, 5, 7, 8, 0};

        assertArrayEquals(expected, actual);
    }
}