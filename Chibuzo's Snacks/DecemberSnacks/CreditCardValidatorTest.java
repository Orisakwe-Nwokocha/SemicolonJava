import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CreditCardValidatorTest {
    private CreditCardValidator creditCardValidator;

    @BeforeEach
    public void setUp() {
        creditCardValidator = new CreditCardValidator();
    }

    @Test
    public void setCardNumber() {
        creditCardValidator.setCardNumber("4388576018410707");
        assertEquals("4388576018410707", creditCardValidator.getCardNumber());
    }

    @Test
    public void getCardNumber() {
        creditCardValidator.setCardNumber("4388576018410707");
        assertEquals("4388576018410707", creditCardValidator.getCardNumber());
    }

    @Test
    public void getCardDigitLength() {
        creditCardValidator.setCardNumber("4388576018410707");
        assertEquals(16, creditCardValidator.getCardDigitLength());
    }

    @Test
    public void setCardType() {
        creditCardValidator.setCardNumber("4388576018410707");
        String creditCard = creditCardValidator.getCardNumber();
        creditCardValidator.setCardType(creditCard);

        assertEquals("Visa Cards", creditCardValidator.getCardType());
    }

    @Test
    public void getCardType() {
        creditCardValidator.setCardType("4388576018410707");
        assertEquals("Visa Cards", creditCardValidator.getCardType());

        creditCardValidator.setCardType("5388576018410707");
        assertEquals("MasterCard", creditCardValidator.getCardType());

        creditCardValidator.setCardType("6388576018410707");
        assertEquals("Discover Cards", creditCardValidator.getCardType());

        creditCardValidator.setCardType("378857601841070");
        assertEquals("American Express Cards", creditCardValidator.getCardType());

        creditCardValidator.setCardType("27857601841070");
        assertEquals("Invalid card", creditCardValidator.getCardType());
    }

    @Test
    public void getCreditCardDigitsArray() {
        creditCardValidator.setCardNumber("4388576018402626");
        int[] expected = {4, 3, 8, 8, 5, 7, 6, 0, 1, 8, 4, 0, 2, 6, 2, 6};
        assertArrayEquals(expected, creditCardValidator.convertToArray());
    }

    @Test
    public void getEvenPositionsSum() {
        creditCardValidator.setCardNumber("4388576018402626");
        assertEquals(37, creditCardValidator.getEvenPositionsSum());
    }

    @Test
    public void getOddPositionsSum() {
        creditCardValidator.setCardNumber("4388576018402626");
        assertEquals(38, creditCardValidator.getOddPositionsSum());
    }

    @Test
    public void getCardValidityStatusWrongCardType() {
        creditCardValidator.setCardNumber("27857601841070");
        String creditCard = creditCardValidator.getCardNumber();
        creditCardValidator.setCardType(creditCard);

        assertEquals("Invalid", creditCardValidator.getCardValidityStatus());
    }

    @Test
    public void getCardValidityStatusResultNotDivisible() {
        creditCardValidator.setCardNumber("4388576018402626");
        String creditCard = creditCardValidator.getCardNumber();
        creditCardValidator.setCardType(creditCard);

        assertEquals("Invalid", creditCardValidator.getCardValidityStatus());
    }

    @Test
    public void getCardValidityStatusResultIsDivisible() {
        creditCardValidator.setCardNumber("4388576018410707");
        String creditCard = creditCardValidator.getCardNumber();
        creditCardValidator.setCardType(creditCard);

        assertEquals("Valid", creditCardValidator.getCardValidityStatus());
    }

}