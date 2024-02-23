package oopAccount;

import oopAccount.exceptions.InsufficientFundsException;
import oopAccount.exceptions.InvalidAmountException;
import oopAccount.exceptions.InvalidPinException;

import java.util.Scanner;

public class BankApp {
    private static final Bank firstBank = new Bank("First Bank of Nigeria PLC");;

    public static void main(String[] args) {
        startApp();
    }

    private static void startApp() {
        registerCustomer();
    }

    private static void goToMainMenu(Account account) {
        String mainMenu = """
                
                What do you want to do today?
                
                1. Deposit
                2. Withdraw
                3. Transfer
                4. Check Balance
                5. Close Account
                6. Exit
                
                Select option:""";


        String userChoice = input(mainMenu);

        switch (userChoice) {
            case "1" -> deposit(account);
            case "2" -> withdraw(account);
            case "3" -> transfer(account);
            case "4" -> checkBalance(account);
            case "5" -> removeAccount(account);
            case "6" -> exitApp();
            default -> goToMainMenu(account);
        }
    }

    private static String input(String prompt) {
        print(prompt);
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    private static void print(String prompt) {
        System.out.println(prompt);
    }

    private static void exitApp() {
        try {
            print("exiting...");
            Thread.sleep(2000);
        }
        catch (InterruptedException ignored) {
        }

        System.exit(0);
    }

    private static void removeAccount(Account account) {
        String pin = input("\nEnter account pin:");

        try {
            firstBank.removeAccount(account.getNumber(), pin);
            print("Account successfully removed.");
        }
        catch (RuntimeException orisha) {
            print(orisha.getMessage());
        }
        finally {
            exitApp();
        }
    }

    private static void checkBalance(Account account) {
        String pin = input("\nEnter account pin:");

        try {
            int balance = firstBank.checkBalance(account.getNumber(), pin);
            print(account.getName() + " balance: ₦" + balance);
        }
        catch (RuntimeException orisha) {
            print(orisha.getMessage());
        }
        finally {
            goToMainMenu(account);
        }
    }

    private static void transfer(Account account) {
        String receiverAccountNumber = input("\nEnter account number to credit:");
        String amount = input("Enter amount to transfer:");
        String pin = input("Enter account pin:");

        try {
            firstBank.transfer(account.getNumber(), Integer.parseInt(receiverAccountNumber),
                    Integer.parseInt(amount), pin);
            print("Amount was successfully transferred.");
        }
        catch (RuntimeException orisha) {
           print(orisha.getMessage());
        }
        finally {
            goToMainMenu(account);
        }
    }

    private static void withdraw(Account account) {
        String amount = input("\nEnter amount to withdraw:");
        String pin = input("Enter account pin:");

        try {
            firstBank.withdraw(account.getNumber(), Integer.parseInt(amount), pin);
            print("Withdraw was successful.");
        }
        catch (RuntimeException orisha) {
            print(orisha.getMessage());
        }
        finally {
            goToMainMenu(account);
        }
    }

    private static void deposit(Account account) {
        String amount = input("\nEnter amount to deposit:");

        try {
            firstBank.deposit(account.getNumber(), Integer.parseInt(amount));
            print("Amount successfully deposited.");
        }
        catch (InvalidAmountException ori) {
            System.out.println(ori.getMessage());
        }
        finally {
            goToMainMenu(account);
        }
    }

    private static void registerCustomer() {
        print("Welcome to first mobile app!!!");

        String firstName = input("Enter first name:");
        String lastName = input("Enter last name:");
        String pin = input("Enter pin:");

        Account account = null;

        try {
            account = firstBank.registerCustomer(firstName, lastName, pin);
        }
        catch (InvalidPinException e) {
            print(e.getMessage());

            registerCustomer();
        }
        finally {
            print("\nAccount successfully created.");
            if (account != null) print("Your account number is " + account.getNumber());

            firstBank.registerCustomer("Jane", "Doe", "0000");

            if (account != null) login(account);
        }

    }

    private static void login(Account account) {
        print("\nWelcome to first mobile app!!!");
        String pin = input("Enter your pin to login:");

        while (account.isInCorrect(pin)) {
            print("Incorrect pin!!!\nPlease enter your pin to login:");
            pin = input("Enter your pin to login:");
        }

        goToMainMenu(account);
    }

}