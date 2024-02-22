package oopAccount;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String name;
    private List<Account> accounts;
    private int numberOfAccounts;

    public Bank(String name) {
        this.name = name;
        accounts = new ArrayList<>();
    }

    public Account registerCustomer(String firstName, String lastName, String pin) {
        String name = firstName + " " + lastName;
        int number = generateAccountNumber();
        Account account = new Account(name, number, pin);

        accounts.add(account);

        return account;
    }

    private int generateAccountNumber() {
         return ++numberOfAccounts;
    }

    public Account findAccount(int accountNumber) {
        for (Account account : accounts) {
            boolean isEqual = account.getNumber() == accountNumber;
            if (isEqual) return account;
        }

        return null;
    }

    public int getAccountNumber(Account account) {
        if (account == null) throw new NullPointerException("Account does not exist.");

        return account.getNumber();
    }

    public String getAccountName(Account account) {
        if (account == null) throw new NullPointerException("Account does not exist.");

        return account.getName();
    }

    public int checkBalance(int accountNumber, String pin) {
        ensureAccountExists(accountNumber);

        Account account = findAccount(accountNumber);

        return account.checkBalance(pin);
    }

    public void deposit(int accountNumber, int amount) {
        ensureAccountExists(accountNumber);

        Account account = findAccount(accountNumber);

        account.deposit(amount);
    }

    private void ensureAccountExists(int accountNumber) {
        Account account = findAccount(accountNumber);

        if (account == null) throw new NullPointerException("Account number provided does not exist.");
    }

    public void withdraw(int accountNumber, int amount, String pin) {
        ensureAccountExists(accountNumber);

        Account account = findAccount(accountNumber);

        account.withdraw(amount, pin);
    }

    public void transfer(int sourceAccountNumber, int destinationAccountNumber, int amount, String pin) {
        ensureAccountExists(sourceAccountNumber);
        ensureAccountExists(destinationAccountNumber);

        Account sourceAccount = findAccount(sourceAccountNumber);
        Account destinationAccount = findAccount(destinationAccountNumber);

        if (sourceAccountNumber == destinationAccountNumber) throw new IllegalArgumentException("Invalid operation.");

        sourceAccount.withdraw(amount, pin);
        destinationAccount.deposit(amount);
    }

    public void removeAccount(int accountNumber, String pin) {
        ensureAccountExists(accountNumber);

        Account account = findAccount(accountNumber);

        if (account.isCorrect(pin)) accounts.remove(account);
    }
}
