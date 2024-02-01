package chapterThree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTest {

    @Test
    public void depositNegativeBalance_balanceRemainsUnchangedTest() {
        Account praiseAccount = new Account();
        assertEquals(0, praiseAccount.getBalance());

        praiseAccount.deposit(-50_000);
        assertEquals(0, praiseAccount.getBalance());
    }

    @Test
    public void depositPositiveAmount_balanceIncreasesTest() {
        Account praiseAccount = new Account();
        assertEquals(0, praiseAccount.getBalance());

        praiseAccount.deposit(2_000);
        assertEquals(2_000, praiseAccount.getBalance());
    }

    @Test
    public void depositPositiveAmountTwice_balanceIncreasesTest() {
        Account praiseAccount = new Account();
        assertEquals(0, praiseAccount.getBalance());

        praiseAccount.deposit(2_000);
        praiseAccount.deposit(4_000);
        assertEquals(6_000, praiseAccount.getBalance());
    }

    @Test
    public void withdrawNegativeBalance_balanceRemainsUnchangedTest() {
        Account praiseAccount = new Account();
        assertEquals(0, praiseAccount.getBalance());

        praiseAccount.withdraw(-50_000);
        assertEquals(0, praiseAccount.getBalance());
    }

    @Test
    public void withdrawPositiveAmount_balanceDecreasesTest() {
        Account praiseAccount = new Account();
        assertEquals(0, praiseAccount.getBalance());

        praiseAccount.deposit(1200);
        praiseAccount.withdraw(1000);
        assertEquals(200, praiseAccount.getBalance());
    }

    @Test
    public void withdrawPositiveAmountAboveBalance_balanceRemainsUnchangedTest() {
        Account praiseAccount = new Account();
        assertEquals(0, praiseAccount.getBalance());

        praiseAccount.deposit(200);
        praiseAccount.withdraw(50_000);
        assertEquals(200, praiseAccount.getBalance());
    }
}
