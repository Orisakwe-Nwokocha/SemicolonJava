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
        int accountNumber = account.getAccountNumber();

        assertEquals(1, accountNumber);
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

        Account expected = firstBank.findAccount(account2.getAccountNumber());

        assertNotEquals(expected, account1);
    }

    @Test
    public void givenBankAccount_testThatAccountIsEmpty() {
        Account account = firstBank.registerCustomer("John", "Doe", "1234");
        int accountNumber = account.getAccountNumber();

        assertEquals(0, firstBank.checkBalance(accountNumber, "1234"));
    }

    @Test
    public void givenBankAccount_when10kIsDeposited_thenBalanceIs10k() {
        Account account = firstBank.registerCustomer("John", "Doe", "1234");
        int accountNumber = account.getAccountNumber();

        firstBank.deposit(accountNumber, 10_000);
        assertEquals(10_000, firstBank.checkBalance(accountNumber, "1234"));
    }

    @Test
    public void given7kBalance_when5kIsWithdrawn_thenBalanceIs2k() {
        Account account = firstBank.registerCustomer("John", "Doe", "1234");
        int accountNumber = account.getAccountNumber();
        firstBank.deposit(accountNumber, 7000);

        firstBank.withdraw(accountNumber, 2000, "1234");
        assertEquals(5000, firstBank.checkBalance(accountNumber, "1234"));
    }

    @Test
    public void transfer25kFromAccount1ToAccount2_account2BalanceIs30k_account1BalanceIs50k() {
        Account john = firstBank.registerCustomer("John", "Doe", "1234");
        Account jane = firstBank.registerCustomer("Jane", "Doe", "0000");
        firstBank.deposit(john.getAccountNumber(), 75_000);
        firstBank.deposit(jane.getAccountNumber(), 5000);

        int johnAccountNumber = john.getAccountNumber();
        int janeAccountNumber = jane.getAccountNumber();

        firstBank.transfer(johnAccountNumber, janeAccountNumber, 25_000, "1234");
        assertEquals(30_000, firstBank.checkBalance(janeAccountNumber, "0000"));
        assertEquals(50_000, firstBank.checkBalance(johnAccountNumber, "1234"));
    }


    @Test
    public void givenAccount_whenRemoved_accountIsNull() {
        Account account = firstBank.registerCustomer("John", "Doe", "1234");
        int accountNumber = account.getAccountNumber();
        assertNotNull(firstBank.findAccount(accountNumber));

        firstBank.removeAccount(account.getAccountNumber(), account.getName());
        assertNull(firstBank.findAccount(accountNumber));
    }

}