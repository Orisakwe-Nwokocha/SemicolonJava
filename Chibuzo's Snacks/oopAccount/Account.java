package oopAccount;

public class Account {
    private String name;
    private int balance;
    private String pin;
    private int number;
    public int checkBalance() {
        return balance;
    }

    public void deposit(int amount) {
        validate(amount);

        balance += amount;
    }

    private static void validate(int amount) {
        boolean amountIsValid = amount > 0;
        if (!amountIsValid) throw new InvalidAmountException("Amount must be greater than zero");
    }

    public void withdraw(int amount) {
        validate(amount);
        ensureSufficientFunds(amount);

        balance -= amount;
    }

    private void ensureSufficientFunds(int amount) {
        boolean fundsIsInsufficient = amount > balance;
        if (fundsIsInsufficient) throw new InsufficientFundsException("Insufficient funds to withdraw: " + amount);
    }
}
