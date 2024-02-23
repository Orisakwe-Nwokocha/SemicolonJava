package oopAccount;

import oopAccount.exceptions.InsufficientFundsException;
import oopAccount.exceptions.InvalidAmountException;
import oopAccount.exceptions.InvalidPinException;

public class Account {
    private String name;
    private int balance;
    private String pin;
    private int number;

    public Account(String name, int number, String pin) {
        validatePinFormatAndLength(pin);

        this.name = name;
        this.number = number;
        this.pin = pin;
    }

    private static void validatePinFormatAndLength(String pin) {
        validatePinFormat(pin);
        validatePinLength(pin);
    }

    private static void validatePinFormat(String pin) {
        boolean hasOnlyDigits = pin.matches("\\d+");

        if (!hasOnlyDigits) throw new InvalidPinException("PIN must consist of only digit numbers.");
    }

    private static void validatePinLength(String pin) {
        boolean isPinLengthValid = pin.length() == 4;

        if (!isPinLengthValid) throw new InvalidPinException("PIN length must be four digits long.");
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
        if (isInCorrect(pin)) throw new InvalidPinException("PIN provided is not valid.");
    }

    private void ensureSufficientFunds(int amount) {
        boolean isInsufficient = amount > balance;

        if (isInsufficient) throw new InsufficientFundsException("Insufficient funds to perform this operation.");
    }

    private static void validateAmount(int amount) {
        boolean amountIsValid = amount > 0;

        if (!amountIsValid) throw new InvalidAmountException("Amount must be greater than zero.");
    }

    public int getNumber() {
        return number;
    }

    public boolean isInCorrect(String pin) {
        return !this.pin.equals(pin);
    }

    public String getName() {
        return name;
    }
}
