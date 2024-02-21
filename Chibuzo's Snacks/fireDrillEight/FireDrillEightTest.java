package fireDrillEight;

import fireDrillEight.FireDrillEight;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FireDrillEightTest {

    @Test
    public void givenBirthDate_whenCalculatingAgeBeforeCurrentBirthday_calculateAge() {
        int actual = FireDrillEight.calculateAge("12/12/2022");
        assertEquals(1, actual);
        assertEquals(26, FireDrillEight.calculateAge("31/07/1997"));
    }

    @Test
    public void givenBirthDate_whenCalculatingAgeOnOrAfterCurrentBirthday_calculateAge() {
        int actual = FireDrillEight.calculateAge("21/02/2022");
        assertEquals(2, actual);
        assertEquals(2, FireDrillEight.secondTry("21/02/2022"));
    }
}