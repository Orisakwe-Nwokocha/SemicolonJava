package mrFemi.chapter14.regex;

import org.junit.jupiter.api.Test;

import static mrFemi.chapter14.regex.DataValidator.isEmailValid;
import static mrFemi.chapter14.regex.DataValidator.isPhoneNumberValid;
import static org.junit.jupiter.api.Assertions.*;

public class DataValidatorTest {

    @Test
    public void testValidatePhoneNumber() {
        String phoneNumber = "";
        boolean isPhoneNumberValid = isPhoneNumberValid(phoneNumber);
        assertFalse(isPhoneNumberValid);
    }

    @Test
    public void testValidatePhoneNumber2() {
        String phoneNumber = "08125358910";
        boolean isPhoneNumberValid = isPhoneNumberValid(phoneNumber);
        assertTrue(isPhoneNumberValid);
    }

    @Test
    public void testValidatePhoneNumber3() {
        String phoneNumber = "+2348125358910";
        boolean isPhoneNumberValid = isPhoneNumberValid(phoneNumber);
        assertTrue(isPhoneNumberValid);
    }

    @Test
    public void testValidatePhoneNumber4() {
        String phoneNumber = "+2348125358910";
        boolean isPhoneNumberValid = isPhoneNumberValid(phoneNumber);
        assertTrue(isPhoneNumberValid);
    }

  @Test
    public void testValidatePhoneNumber5() {
        String phoneNumber = "2348125358910";
        boolean isPhoneNumberValid = isPhoneNumberValid(phoneNumber);
        assertTrue(isPhoneNumberValid);
    }

    @Test
    public void testValidatePhoneNumber6() {
        String phoneNumber = "2347125358910";
        boolean isPhoneNumberValid = isPhoneNumberValid(phoneNumber);
        assertFalse(isPhoneNumberValid);
    }

    @Test
    public void testValidatePhoneNumber7() {
        String phoneNumber = "+234-7025358910";
        boolean isPhoneNumberValid = isPhoneNumberValid(phoneNumber);
        assertTrue(isPhoneNumberValid);
    }

    @Test
    public void testValidatePhoneNumber8() {
        String phoneNumber = "234 702 535 8910";
        boolean isPhoneNumberValid = isPhoneNumberValid(phoneNumber);
        assertTrue(isPhoneNumberValid);
    }

    @Test
    public void testValidatePhoneNumber9() {
        String phoneNumber = "7025358910";
        boolean isPhoneNumberValid = isPhoneNumberValid(phoneNumber);
        assertTrue(isPhoneNumberValid);
    }

    @Test
    public void testValidateEmailNumber() {
        String email = "o.nwokocha@native.semicolon.africa";
        boolean isEmailValid = isEmailValid(email);
        assertTrue(isEmailValid);
    }

    @Test
    public void testValidateEmailNumber2() {
        String email = "o.nwokocha@native.semicolon.africa".toUpperCase();
        boolean isEmailValid = isEmailValid(email);
        assertTrue(isEmailValid);
    }

    @Test
    public void testValidateEmailNumber3() {
        String email = "Nwokocha@semicolon.africa".toUpperCase();
        boolean isEmailValid = isEmailValid(email);
        assertTrue(isEmailValid);
    }

}