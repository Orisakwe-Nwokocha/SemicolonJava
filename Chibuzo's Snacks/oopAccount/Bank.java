package oopAccount;

import oopAccount.exceptions.InvalidPinException;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private final String name;
    private final List<Account> accounts;
    private int lastAccountCreated;

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
         return ++lastAccountCreated;
    }

    public Account findAccount(int accountNumber) {
        for (Account account : accounts) {
            boolean isEqual = account.getNumber() == accountNumber;
            if (isEqual) return account;
        }

        throw new NullPointerException("Account does not exist.");
    }

    public int checkBalance(int accountNumber, String pin) {
        Account account = findAccount(accountNumber);

        return account.checkBalance(pin);
    }

    public void deposit(int accountNumber, int amount) {
        Account account = findAccount(accountNumber);

        account.deposit(amount);
    }

    public void withdraw(int accountNumber, int amount, String pin) {
        Account account = findAccount(accountNumber);

        account.withdraw(amount, pin);
    }

    public void transfer(int senderAccountNumber, int receiverAccountNumber, int amount, String pin) {
        Account sender = findAccount(senderAccountNumber);
        Account receiver = findAccount(receiverAccountNumber);

        sender.withdraw(amount, pin);
        receiver.deposit(amount);
    }

    public void removeAccount(int accountNumber, String pin) {
        Account account = findAccount(accountNumber);
        if (account.isInCorrect(pin)) throw new InvalidPinException("PIN provided is not valid.");

        accounts.remove(account);
    }

    public String getName() {
        return name;
    }
}
