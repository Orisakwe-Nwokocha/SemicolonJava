package oopAccount;

import oopAccount.exceptions.InsufficientFundsException;
import oopAccount.exceptions.InvalidAmountException;
import oopAccount.exceptions.InvalidPinException;

import java.util.Scanner;

public class BankApp {
    private Bank bank;
    private final Scanner input = new Scanner(System.in);

    public void main() {
        bank = new Bank("First Bank of Nigeria PLC");
        startApp();
    }

    private void startApp() {
        Account account = registerCustomer();

        menu(account);
    }

    private void menu(Account account) {
        System.out.println("""
                
                1. Deposit
                2. Withdraw
                3. Transfer
                4. Check Balance
                5. Delete Account
                6. Exit
                
                Select option:""");
        String userChoice = input.next();

        switch (userChoice) {
            case "1" -> deposit(account);
            case "2" -> withdraw(account);
            case "3" -> transfer(account);
            case "4" -> checkBalance(account);
            case "5" -> removeAccount(account);
            case "6" -> exit();
            default -> menu(account);
        }
    }

    private void exit() {
        try {
            System.out.println("exiting...");
            Thread.sleep(3000);
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.exit(0);
    }

    private void removeAccount(Account account) {
        System.out.println("\nEnter account pin:");
        String pin = input.next();

        try {
            bank.removeAccount(bank.getAccountNumber(account), pin);
            System.out.println("Account successfully removed.");
        }
        catch (NullPointerException | InvalidPinException ori) {
            System.out.println(ori.getMessage());
        }

        exit();
    }

    private void checkBalance(Account account) {
        System.out.println("\nEnter account pin:");
        String pin = input.next();

        try {
            int balance = bank.checkBalance(bank.getAccountNumber(account), pin);
            System.out.printf("%s balance: ₦%d%n", bank.getAccountName(account), balance);
        }
        catch (NullPointerException | InvalidPinException ori) {
            System.out.println(ori.getMessage());
        }

        menu(account);
    }

    private void transfer(Account account) {
        System.out.println("\nEnter amount to transfer:");
        int amount = input.nextInt();
        System.out.println("Enter account number to credit:");
        int destinationAccountNumber = input.nextInt();
        System.out.println("Enter account pin:");
        String pin = input.next();

        try {
            bank.transfer(bank.getAccountNumber(account), destinationAccountNumber, amount, pin);
        }
        catch (NullPointerException | InvalidPinException | InvalidAmountException | InsufficientFundsException |
                IllegalArgumentException ori) {
            System.out.println(ori.getMessage());
        }

        menu(account);
    }

    private void withdraw(Account account) {
        System.out.println("\nEnter amount to withdraw:");
        int amount = input.nextInt();
        System.out.println("Enter account pin:");
        String pin = input.next();

        try {
            bank.withdraw(bank.getAccountNumber(account), amount, pin);
        }
        catch (InvalidPinException | InvalidAmountException | InsufficientFundsException ori) {
            System.out.println(ori.getMessage());
        }

        menu(account);
    }

    private void deposit(Account account) {
        System.out.println("\nEnter amount to deposit:");
        int amount = input.nextInt();

        try {
            bank.deposit(bank.getAccountNumber(account), amount);
        }
        catch (InvalidAmountException ori) {
            System.out.println(ori.getMessage());
        }

        menu(account);
    }

    private Account registerCustomer() {
        System.out.println("Enter first name:");
        String firstName = input.next();
        input.nextLine();

        System.out.println("Enter last name:");
        String lastName = input.next();

        System.out.println("Enter pin:");
        String pin = input.next();

        Account account = bank.registerCustomer(firstName, lastName, pin);
        Account janeDoe = bank.registerCustomer("Jane", "Doe", "0000");

        return account;
    }
}