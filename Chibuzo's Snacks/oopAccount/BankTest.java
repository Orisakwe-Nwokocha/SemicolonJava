package oopAccount;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankTest {

    @Test
    public void givenBankAccount_testThatAccountIsEmpty() {
        Bank firstBank = new Bank();

        Account account = firstBank.findAccount(1);
        assertEquals(0, firstBank.checkBalance(1, "1234"));
    }

    @Test
    public void givenBankAccount_when10kIsDeposited_thenBalanceIs10k() {
        Bank firstBank = new Bank();

        Account account = firstBank.findAccount(1);
        firstBank.deposit(1, 10_000);
        assertEquals(10_000, firstBank.checkBalance(1, "1234"));
    }

}