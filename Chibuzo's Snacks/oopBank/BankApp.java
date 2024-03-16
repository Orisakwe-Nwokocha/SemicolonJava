package oopBank;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class BankApp {
    private static final Bank firstBank = new Bank("First Bank of Nigeria PLC");
    private static Account account = new Account("dummyName", -10000, "9999");
    private static final List<Bank> otherBanks = new ArrayList<>();

    public static void main(String[] args) {
        startApp();
    }

    private static void startApp() {
        print("Welcome to First Bank!!!");

        addOtherBanks();
    }

    private static void addOtherBanks() {
        Bank gtBank = new Bank("Guaranty Trust Bank of Nigeria PLC");
        Bank accessBank = new Bank("Access Bank of Nigeria PLC");
        otherBanks.add(gtBank);
        otherBanks.add(accessBank);

        otherBanks.getFirst().registerCustomer("Jane", "Doe", "0000");
        otherBanks.getLast().registerCustomer("FirstName", "LastName", "4321");

        goToMainMenu();
    }

    private static void goToMainMenu() {
        String mainMenu = """         
                What do you want to do today?
                
                1. Create a new account.
                2. Deposit
                3. Withdraw
                4. Transfer
                5. Check Balance
                6. Close Account
                7. Exit App
                
                Select option:""";


        String userChoice = input(mainMenu);

        switch (userChoice) {
            case "1" -> registerCustomer();
            case "2" -> deposit();
            case "3" -> withdraw();
            case "4" -> transfer();
            case "5" -> checkBalance();
            case "6" -> removeAccount();
            case "7" -> exitApp();
            default -> goToMainMenu();
        }
    }

    private static String input(String prompt) {
        return JOptionPane.showInputDialog(prompt);
    }

    private static void print(String prompt) {
        JOptionPane.showMessageDialog(null, prompt);
    }

    private static void exitApp() {
        print("exiting...");
        print("Thanks for using our app!!!");

        System.exit(0);
    }

    private static void removeAccount() {
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

    private static void checkBalance() {
        String pin = input("Enter account pin:");

        try {
            int balance = firstBank.checkBalance(account.getNumber(), pin);
            print(account.getName() + " balance: ₦" + balance);
        }
        catch (RuntimeException orisha) {
            print(orisha.getMessage());
        }
        finally {
            goToMainMenu();
        }
    }

    private static void transfer() {
        String userChoice = input("""
                Enter 1 to transfer to first bank accounts
                Enter 2 to transfer to other bank accounts""");

        if (userChoice.equals("1")) intraBankTransfer(account);
        else if (userChoice.equals("2")) interBankTransfer(account);
        else goToMainMenu();
    }

    private static void interBankTransfer(Account account) {
        for (Bank bank : otherBanks) print("*".repeat(5) + bank.getName() + "*".repeat(5));

        String choice = input("Select option (1 or 2):");
        if (choice.equals("1")) transferToGtBankAccounts(account);
        else if (choice.equals("2")) transferToAccessBankAccounts(account);

        goToMainMenu();
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
            goToMainMenu();
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
            goToMainMenu();
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
            goToMainMenu();
        }
    }

    private static void withdraw() {
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
            goToMainMenu();
        }
    }

    private static void deposit() {
        String amount = input("Enter amount to deposit:");

        try {
            firstBank.deposit(account.getNumber(), Integer.parseInt(amount));
            print("Amount successfully deposited.");
        }
        catch (RuntimeException ori) {
            print(ori.getMessage());
        }
        finally {
            goToMainMenu();
        }
    }

    private static void registerCustomer() {
        String firstName = input("Enter first name:");
        String lastName = input("Enter last name:");
        String pin = input("Enter pin:");


        try {
            account = firstBank.registerCustomer(firstName, lastName, pin);
        }
        catch (RuntimeException e) {
            print(e.getMessage());
            print("Account creation was not successful");
            
            goToMainMenu();
        }
        finally {
            print("Account successfully created.");
            print("Your account number is " + account.getNumber());

            login(account);
        }

    }

    private static void login(Account account) {
        print("Welcome to first mobile app!!!");
        String pin = input("Enter your pin to login:");

        int count = 0;

        while (account.isInCorrect(pin)) {
            count++;

            print("Incorrect pin!!!");

            if (count == 3) getChoice();

            pin = input("Enter your pin to login:");
        }

        goToMainMenu();
    }

    private static void getChoice() {
        int choice = JOptionPane.showConfirmDialog(null, "Do you want to create another account?",
            "Yes/No", JOptionPane.YES_NO_OPTION);
        if (choice == 0) registerCustomer();
        else goToMainMenu();
    }
}