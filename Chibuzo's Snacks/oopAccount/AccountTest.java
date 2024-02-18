package oopAccount;

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
}