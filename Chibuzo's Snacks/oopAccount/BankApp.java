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


        /*Account johnDoe = bank.registerCustomer("John", "Doe", "1234");
        Account janeDoe = bank.registerCustomer("Jane", "Doe", "0000");

        displayHeader("\nInitial balance of the accounts:");
        displayBalance(bank, johnDoe, "1234");
        displayBalance(bank, janeDoe, "0000");

        bank.deposit(johnDoe.getAccountNumber(), 10_000);
        displayHeader("\nBalance after deposit:");
        displayBalance(bank, johnDoe, "1234");

        bank.withdraw(johnDoe.getAccountNumber(), 4000, "1234");
        displayHeader("\nBalance after withdrawal:");
        displayBalance(bank, johnDoe, "1234");

        bank.transfer(johnDoe.getAccountNumber(), janeDoe.getAccountNumber(), 2000, "1234");
        displayHeader("\nBalance after transferring urgent 2k to Jane Doe:");
        displayBalance(bank, johnDoe, "1234");
        displayBalance(bank, janeDoe, "0000");

        int accountNumber = janeDoe.getAccountNumber();
        bank.removeAccount(janeDoe.getAccountNumber(), "0000");

        String output = bank.findAccount(accountNumber) == null ?
                "Account successfully removed." : "Account removal unsuccessful.";
        displayHeader("");
        System.out.printf("%s%n", output);*/
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
                
                Select option:
                """);
        String userChoice = input.next();

        switch (userChoice) {
            case "1" -> deposit(account);
            case "2" -> withdraw(account);
            case "3" -> transfer(account);
            case "4" -> checkBalance(account);
            case "5" -> removeAccount();
            case "6" -> exit();
            default -> menu(account);
        }
    }

    private void exit() {
        try {
            System.out.println("exiting...");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.exit(0);
    }

    private void removeAccount() {
    }

    private void checkBalance(Account account) {
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
        catch (InvalidAmountException | InsufficientFundsException | InvalidPinException | NullPointerException ori) {
            System.out.println(ori.getMessage());
        }
    }

    private void withdraw(Account account) {
        System.out.println("\nEnter amount to withdraw:");
        int amount = input.nextInt();
        System.out.println("Enter account pin:");
        String pin = input.next();

        bank.withdraw(bank.getAccountNumber(account), amount, pin);

        menu(account);
    }

    private void deposit(Account account) {
        System.out.println("\nEnter amount to deposit:");
        int amount = input.nextInt();

        bank.deposit(bank.getAccountNumber(account), amount);

        menu(account);
    }

    private Account registerCustomer() {
        System.out.println("Enter first name:");
        String firstName = input.next();

        System.out.println("Enter last name:");
        String lastName = input.next();

        System.out.println("Enter pin:");
        String pin = input.next();

        Account account = bank.registerCustomer(firstName, lastName, pin);
        Account janeDoe = bank.registerCustomer("Jane", "Doe", "0000");

        return account;
    }

    private static void displayHeader(String header) {
        System.out.println(header);
    }

    private static void displayBalance(Bank bank, Account account, String pin) {
        int balance = bank.checkBalance(account.getAccountNumber(), pin);
        System.out.printf("%s balance: ₦%d%n", account.getName(), balance);
    }
}