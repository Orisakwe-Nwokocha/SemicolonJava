package oopAccount;

public class Account {
    private String name;
    private int balance;
    private String pin;
    private int number;

    public Account(String pin) {
        validatePinFormatAndLength(pin);
        this.pin = pin;
    }

    private static void validatePinFormatAndLength(String pin) {
        validatePinFormat(pin);
        validatePinLength(pin);
    }

    private static void validatePinFormat(String pin) {
        boolean hasOnlyDigits = pin.matches("\\d+");
        if (!hasOnlyDigits) throw new InvalidPinException("PIN must consist of only digit numbers");
    }

    private static void validatePinLength(String pin) {
        boolean isPinLengthValid = pin.length() == 4;
        if (!isPinLengthValid) throw new InvalidPinException("PIN length must be four digits long");
    }


    public void deposit(int amount) {
        validateAmount(amount);

        balance += amount;
    }

    public void withdraw(int amount, String pin) {
        validateWithdrawOperation(amount, pin);

        balance -= amount;
    }

    public int checkBalance(String pin) {
        validatePin(pin);

        return balance;
    }

    private void validateWithdrawOperation(int amount, String pin) {
        validatePin(pin);
        validateAmount(amount);
        ensureSufficientFunds(amount);
    }

    private void validatePin(String pin) {
        boolean isValidPin = this.pin.equals(pin);
        if (!isValidPin) throw new InvalidPinException("PIN provided is not valid");
    }

    private void ensureSufficientFunds(int amount) {
        boolean fundsIsInsufficient = amount > balance;
        if (fundsIsInsufficient) throw new InsufficientFundsException("Insufficient funds to withdraw: " + amount);
    }

    private static void validateAmount(int amount) {
        boolean amountIsValid = amount > 0;
        if (!amountIsValid) throw new InvalidAmountException("Amount must be greater than zero");
    }
}
