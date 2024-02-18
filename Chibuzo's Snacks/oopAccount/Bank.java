package oopAccount;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String name;
    private List<Account> accounts;

    public Bank() {
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
         return accounts.size() + 1;
    }

    public Account findAccount(int accountNumber) {
        if (accounts.isEmpty()) return null;

        for (Account account : accounts) if (isEqual(accountNumber, account)) return account;

        return null;
    }

    private boolean isEqual(int accountNumber, Account account) {
        return account.getAccountNumber() == accountNumber;
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
        boolean accountIsNull = account == null;

        if (accountIsNull) throw new NullPointerException("Account number provided does not exist");
    }


    public void withdraw() {

    }
}
