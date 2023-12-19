import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DiscountArrayTest {

    @Test
    public void testMyDiscount() {
        double actual = DiscountArray.myDiscount(150, 15);
        assertEquals(127.5, actual);
    }
}