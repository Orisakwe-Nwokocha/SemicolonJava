package oopAccount;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class BankApp {
    private static final Bank firstBank = new Bank("First Bank of Nigeria PLC");
    private static final List<Bank> otherBanks = new ArrayList<>();

    public static void main(String[] args) {
        startApp();
    }

    private static void startApp() {
        addOtherBanks();
    }

    private static void addOtherBanks() {
        Bank gtBank = new Bank("Guaranty Trust Bank of Nigeria PLC");
        Bank accessBank = new Bank("Access Bank of Nigeria PLC");
        otherBanks.add(gtBank);
        otherBanks.add(accessBank);

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
        return JOptionPane.showInputDialog(prompt);
    }

    private static void print(String prompt) {
        JOptionPane.showMessageDialog(null, prompt);
    }

    private static void exitApp() {
        try {
            print("exiting...");
            Thread.sleep(1500);
        }
        catch (InterruptedException ignored) {
        }

        System.exit(0);
    }

    private static void removeAccount(Account account) {
        String pin = input("Enter account pin:");

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
        String pin = input("Enter account pin:");

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
        String userChoice = input("""
                Enter 1 to transfer to first bank accounts
                Enter 2 to transfer to other bank accounts""");

        if (userChoice.equals("1")) intraBankTransfer(account);
        else if (userChoice.equals("2")) interBankTransfer(account);
        else goToMainMenu(account);
    }

    private static void interBankTransfer(Account account) {
        for (Bank bank : otherBanks) print("*".repeat(5) + bank.getName() + "*".repeat(5));

        String choice = input("Select option (1 or 2):");
        if (choice.equals("1")) transferToGtBankAccounts(account);
        else if (choice.equals("2")) transferToAccessBankAccounts(account);

        goToMainMenu(account);
    }

    private static void transferToAccessBankAccounts(Account account) {
        String receiverAccountNumber = input("Enter account number to credit:");
        String amount = input("Enter amount to transfer:");
        String pin = input("Enter account pin:");

        try {
            account.withdraw(Integer.parseInt(amount), pin);
            otherBanks.getLast().deposit(Integer.parseInt(receiverAccountNumber), Integer.parseInt(amount));
            print("Amount was successfully transferred.");
        }
        catch (RuntimeException orisha) {
            print(orisha.getMessage());
        }
        finally {
            goToMainMenu(account);
        }
    }

    private static void transferToGtBankAccounts(Account account) {
        String receiverAccountNumber = input("Enter account number to credit:");
        String amount = input("Enter amount to transfer:");
        String pin = input("Enter account pin:");

        try {
            account.withdraw(Integer.parseInt(amount), pin);
            otherBanks.getFirst().deposit(Integer.parseInt(receiverAccountNumber), Integer.parseInt(amount));
            print("Amount was successfully transferred.");
        }
        catch (RuntimeException orisha) {
            print(orisha.getMessage());
        }
        finally {
            goToMainMenu(account);
        }
    }

    private static void intraBankTransfer(Account account) {
        String receiverAccountNumber = input("Enter account number to credit:");
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
        String amount = input("Enter amount to withdraw:");
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
        String amount = input("Enter amount to deposit:");

        try {
            firstBank.deposit(account.getNumber(), Integer.parseInt(amount));
            print("Amount successfully deposited.");
        }
        catch (RuntimeException ori) {
            print(ori.getMessage());
        }
        finally {
            goToMainMenu(account);
        }
    }

    private static void registerCustomer() {
        print("Welcome to First Bank.\nEnter your details to create an account");

        String firstName = input("Enter first name:");
        String lastName = input("Enter last name:");
        String pin = input("Enter pin:");

        try {
            Account.validatePinFormatAndLength(pin);
        }
        catch (RuntimeException e) {
            print("Account creation was not successful");
            registerCustomer();
        }
        finally {
            Account account = firstBank.registerCustomer(firstName, lastName, pin);
            print("Account successfully created.");
            print("Your account number is " + account.getNumber());

            firstBank.registerCustomer("FirstName", "LastName", "1020");
            otherBanks.getFirst().registerCustomer("Jane", "Doe", "0000");
            otherBanks.getLast().registerCustomer("FirstName", "LastName", "4321");

            login(account);
        }

    }

    private static void login(Account account) {
        print("Welcome to first mobile app!!!");
        String pin = input("Enter your pin to login:");

        while (account.isInCorrect(pin)) {
            print("Incorrect pin!!!");
            pin = input("Enter your pin to login:");
        }

        goToMainMenu(account);
    }
}