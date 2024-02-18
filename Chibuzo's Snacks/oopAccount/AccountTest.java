package oopAccount;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    @Test
    public void givenAccount_testThatAccountIsEmpty() {
        Account account = new Account();
        assertEquals(0, account.checkBalance());
    }

    @Test
    public void givenAccount_when10kIsDeposited_thenBalanceIs10k() {
        Account account = new Account();
        account.deposit(10_000);
        assertEquals(10_000, account.checkBalance());
    }

    @Test
    public void givenAccount_when10kIsDepositedTwice_thenBalanceIs20k() {
        Account account = new Account();
        account.deposit(10_000);
        account.deposit(10_000);
        assertEquals(20_000, account.checkBalance());
    }

    @Test
    public void givenAccount_whenDepositingNonPositiveAmount_thenInvalidAmountExceptionIsThrown() {
        Account account = new Account();
        account.deposit(10_000);
        assertEquals(10_000, account.checkBalance());


        assertThrows(InvalidAmountException.class, ()-> account.deposit(0));
        assertThrows(InvalidAmountException.class, ()-> account.deposit(-5000));
    }

    @Test
    public void given10kBalance_when7kIsWithdrawn_thenBalanceIs3k() {
        Account account = new Account();
        account.deposit(10_000);

        account.withdraw(7000);
        assertEquals(3000, account.checkBalance());
    }

    @Test
    public void givenAccount_whenWithdrawingNonPositiveAmount_thenInvalidAmountExceptionIsThrown() {
        Account account = new Account();
        account.deposit(10_000);
        assertEquals(10_000, account.checkBalance());

        assertThrows(InvalidAmountException.class, ()-> account.withdraw(0));
        assertThrows(InvalidAmountException.class, ()-> account.withdraw(-5000));
    }

    @Test
    public void given10kBalance_when20kIsWithdrawn_thenInsufficientFundsExceptionIsThrown() {
        Account account = new Account();
        account.deposit(10_000);
        assertEquals(10_000, account.checkBalance());

        assertThrows(InsufficientFundsException.class, ()-> account.withdraw(10_001));
        assertThrows(InsufficientFundsException.class, ()-> account.withdraw(15_000));
    }

    @Test
    public void givenAccount_whenWithdrawingUsingAnIncorrectPin_thenInvalidPinExceptionIsThrown() {
        Account account = new Account();
        account.deposit(10_000);
        assertEquals(10_000, account.checkBalance());

        assertThrows(InvalidPinException.class, ()-> account.withdraw(5_000, "1234"));
    }

    @Test
    public void givenAccount_whenCheckingBalanceUsingAnIncorrectPin_thenInvalidPinExceptionIsThrown() {
        Account account = new Account();
        account.deposit(10_000);
        assertEquals(10_000, account.checkBalance());

        assertThrows(InsufficientFundsException.class, ()-> account.withdraw(10_001));
        assertThrows(InsufficientFundsException.class, ()-> account.withdraw(15_000));
    }
}