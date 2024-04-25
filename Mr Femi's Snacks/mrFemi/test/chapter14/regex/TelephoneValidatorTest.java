package mrFemi.chapter14.regex;

import org.junit.jupiter.api.Test;

import static mrFemi.chapter14.regex.TelephoneValidator.validate;
import static org.junit.jupiter.api.Assertions.*;

public class TelephoneValidatorTest {

    @Test
    public void validateTelephoneTest() {
        String telephone = "1 555-555-5555";
        assertTrue(validate(telephone));
    }

    @Test
    public void validateTelephoneTest2() {
        String telephone = "1 (555)-555-5555";
        assertTrue(validate(telephone));
    }

    @Test
    public void validateTelephoneTest3() {
        String telephone = "1 555)-555-5555";
        assertFalse(validate(telephone));
    }

    @Test
    public void validateTelephoneTest4() {
        String telephone = "27576227382";
        assertFalse(validate(telephone));
    }
}