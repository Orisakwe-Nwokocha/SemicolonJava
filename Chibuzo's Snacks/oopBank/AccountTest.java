package oopBank;

import oopBank.exceptions.InsufficientFundsException;
import oopBank.exceptions.InvalidAmountException;
import oopBank.exceptions.InvalidPinException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {
    private Account account;

    @BeforeEach
    public void initializeAccount() {
        account = new Account("John Doe", 1, "1234");
    }

    @Test
    public void givenAccount_testThatAccountIsEmpty() {
        assertEquals(0, account.checkBalance("1234"));
    }

    @Test
    public void givenAccount_when10kIsDeposited_thenBalanceIs10k() {
        account.deposit(10_000);
        assertEquals(10_000, account.checkBalance("1234"));
    }

    @Test
    public void givenAccount_when10kIsDepositedTwice_thenBalanceIs20k() {
        account.deposit(10_000);
        account.deposit(10_000);
        assertEquals(20_000, account.checkBalance("1234"));
    }

    @Test
    public void givenAccount_whenDepositingNonPositiveAmount_thenInvalidAmountExceptionIsThrown() {
        account.deposit(10_000);
        assertEquals(10_000, account.checkBalance("1234"));


        assertThrows(InvalidAmountException.class, ()-> account.deposit(0));
        assertThrows(InvalidAmountException.class, ()-> account.deposit(-5000));
    }

    @Test
    public void given10kBalance_when7kIsWithdrawn_thenBalanceIs3k() {
        account.deposit(10_000);

        account.withdraw(7000, "1234");
        assertEquals(3000, account.checkBalance("1234"));
    }

    @Test
    public void givenAccount_whenWithdrawingNonPositiveAmount_thenInvalidAmountExceptionIsThrown() {
        account.deposit(10_000);
        assertEquals(10_000, account.checkBalance("1234"));

        assertThrows(InvalidAmountException.class, ()-> account.withdraw(0, "1234"));
        assertThrows(InvalidAmountException.class, ()-> account.withdraw(-5000, "1234"));
    }

    @Test
    public void given10kBalance_when20kIsWithdrawn_thenInsufficientFundsExceptionIsThrown() {
        account.deposit(10_000);
        assertEquals(10_000, account.checkBalance("1234"));

        assertThrows(InsufficientFundsException.class, ()-> account.withdraw(10_001, "1234"));
        assertThrows(InsufficientFundsException.class, ()-> account.withdraw(15_000, "1234"));
    }

    @Test
    public void givenAccount_whenWithdrawingUsingAnIncorrectPin_thenInvalidPinExceptionIsThrown() {
        account.deposit(10_000);
        assertEquals(10_000, account.checkBalance("1234"));

        assertThrows(InvalidPinException.class, ()-> account.withdraw(5_000, "0000"));
    }

    @Test
    public void givenAccount_whenCheckingBalanceUsingAnIncorrectPin_thenInvalidPinExceptionIsThrown() {
        account.deposit(10_000);

        assertThrows(InvalidPinException.class, ()-> account.checkBalance("4444"));
    }

    @Test
    public void checkBalanceWithIncorrectPin_testInvalidPinExceptionMessage() {
        try {
            account.checkBalance("0000");
        }
        catch (InvalidPinException orisha) {
            assertEquals("PIN provided is not valid.", orisha.getMessage());
        }
    }

    @Test
    public void deposit2k_withdraw5kWithCorrectPin_testInsufficientExceptionMessage_balanceIs2k() {
        account.deposit(2_000);
        assertEquals(2_000, account.checkBalance("1234"));

        try {
            account.withdraw(5_000, "1234");
        }
        catch (InsufficientFundsException orisha) {
            assertEquals("Insufficient funds to perform this operation.", orisha.getMessage());
        }

        assertEquals(2_000, account.checkBalance("1234"));
    }

    @Test
    public void depositMinus5k_testInvalidAmountMessage_balanceIs0() {
        assertEquals(0, account.checkBalance("1234"));

        try {
            account.deposit(-5_000);
        }
        catch (InvalidAmountException orisha) {
            assertEquals("Amount must be greater than zero.", orisha.getMessage());
        }

        assertEquals(0, account.checkBalance("1234"));
    }

    @Test
    public void customarySetterGetterTest() {
        assertEquals("John Doe", account.getName());
        assertEquals(1, account.getNumber());
    }
}