package oopAccount;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankTest {
    private Bank firstBank;

    @BeforeEach
    public void instantiateBank() {
        firstBank = new Bank();
    }

    @Test
    public void givenBank_testThatBankCanRegisterCustomerAccount() {
        Account account = firstBank.registerCustomer("John", "Doe", "1234");
        int accountNumber = account.getAccountNumber();

        assertEquals(1, accountNumber);
    }

    @Test
    public void givenBank_when5CustomersAreRegistered_thenCustomer5AccountNumberIs5() {
        Account customer1 = firstBank.registerCustomer("John", "Doe", "1234");
        Account customer2 = firstBank.registerCustomer("Place", "Holder", "4321");
        Account customer3 = firstBank.registerCustomer("Temp", "Temp", "4321");
        Account customer4 = firstBank.registerCustomer("Temp", "Temp", "4321");
        Account customer5 = firstBank.registerCustomer("Jane", "Doe", "0000");

        int actualNumber = customer5.getAccountNumber();
        int expectedNumber = firstBank.findAccount(5).getAccountNumber();

        assertEquals(expectedNumber, actualNumber);
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
        firstBank.deposit(accountNumber, 7_000);

        firstBank.withdraw();
        assertEquals(2000, firstBank.checkBalance(accountNumber, "1234"));
    }

}