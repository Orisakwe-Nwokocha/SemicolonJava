package oopAccount;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankTest {
    private Bank firstBank;

    @BeforeEach
    public void instantiateBank() {
        firstBank = new Bank("First Bank");
    }

    @Test
    public void givenBank_testThatBankCanRegisterCustomerAccount() {
        Account account = firstBank.registerCustomer("John", "Doe", "1234");
        int accountNumber = account.getNumber();
        String accountName = account.getName();

        assertEquals(1, accountNumber);
        assertEquals("John Doe", accountName);
    }

    @Test
    public void givenSameAccountNumber_whenEquals_thenAccountObjectsEqual() {
        Account account = firstBank.registerCustomer("John", "Doe", "1234");
        Account expected = firstBank.findAccount(1);

        assertEquals(expected, account);
    }

    @Test
    public void givenDifferentAccountNumbers_whenEquals_thenAccountObjectsNotEqual() {
        Account account1 = firstBank.registerCustomer("John", "Doe", "1234");
        Account account2 = firstBank.registerCustomer("John", "Doe", "1234");

        Account expected = firstBank.findAccount(account2.getNumber());

        assertNotEquals(expected, account1);
    }

    @Test
    public void givenBankAccount_testThatAccountIsEmpty() {
        Account account = firstBank.registerCustomer("John", "Doe", "1234");
        int accountNumber = account.getNumber();

        assertEquals(0, firstBank.checkBalance(accountNumber, "1234"));
    }

    @Test
    public void givenBankAccount_when10kIsDeposited_thenBalanceIs10k() {
        Account account = firstBank.registerCustomer("John", "Doe", "1234");
        int accountNumber = account.getNumber();

        firstBank.deposit(accountNumber, 10_000);
        assertEquals(10_000, firstBank.checkBalance(accountNumber, "1234"));
    }

    @Test
    public void given7kBalance_when5kIsWithdrawn_thenBalanceIs2k() {
        Account account = firstBank.registerCustomer("John", "Doe", "1234");
        int accountNumber = account.getNumber();
        firstBank.deposit(accountNumber, 7000);

        firstBank.withdraw(accountNumber, 2000, "1234");
        assertEquals(5000, firstBank.checkBalance(accountNumber, "1234"));
    }

    @Test
    public void transfer25kFromAccount1ToAccount2_account2BalanceIs30k_account1BalanceIs50k() {
        Account john = firstBank.registerCustomer("John", "Doe", "1234");
        Account jane = firstBank.registerCustomer("Jane", "Doe", "0000");
        firstBank.deposit(john.getNumber(), 75_000);
        firstBank.deposit(jane.getNumber(), 5000);


        firstBank.transfer(john.getNumber(), jane.getNumber(), 25_000, "1234");
        assertEquals(30_000, firstBank.checkBalance(jane.getNumber(), "0000"));
        assertEquals(50_000, firstBank.checkBalance(john.getNumber(), "1234"));
    }


    @Test
    public void givenAccount_whenRemoved_accountIsNull() {
        Account account = firstBank.registerCustomer("John", "Doe", "1234");
        int accountNumber = account.getNumber();
        assertNotNull(firstBank.findAccount(accountNumber));

        firstBank.removeAccount(account.getNumber(), "1234");
        assertThrows(NullPointerException.class, ()-> firstBank.findAccount(accountNumber));
    }
}