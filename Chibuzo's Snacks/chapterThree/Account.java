package chapterThree;

public class Account {
    private int balance;

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        if (amount > 0) balance += amount;
    }

    public void withdraw(int amount) {
        if (amount > 0 && amount < balance) balance -= amount;
    }
}
