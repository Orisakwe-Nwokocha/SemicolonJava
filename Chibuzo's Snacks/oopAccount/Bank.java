package oopAccount;

import java.util.List;

public class Bank {
    private String name;
    private List<Account> accounts;

    public Account findAccount(int accountNo) {
        return null;
    }

    public int checkBalance(int accountNo, String pin) {
        Account account = findAccount(accountNo);
        return account.checkBalance();
    }

    public void deposit(int accountNo, int amount) {

    }
}
