package oopAccount;

import java.util.Scanner;

public class BankAppVersion2 {
    private Bank bank;
    private static final Scanner input = new Scanner(System.in);

    public void main() {
        bank = new Bank("Access Bank PLC");

        AccountInfo accountInfo = getAccountInfo();
        Account account1 = bank.registerCustomer(accountInfo.firstName(), accountInfo.lastName(), accountInfo.pin());

        String pin = getPin();
        displayHeader("\nInitial balance of account:");
        displayBalance(bank, account1, pin);

        System.out.println("\nEnter amount to deposit:");
        int amount = input.nextInt();
        bank.deposit(account1.getAccountNumber(), amount);

        pin = getPin();
        displayHeader("\nBalance after deposit:");
        displayBalance(bank, account1, pin);

        System.out.println("\nEnter amount to withdraw:");
        amount = input.nextInt();
        System.out.println("Enter account pin:");
        pin = input.next();
        bank.withdraw(account1.getAccountNumber(), amount, pin);

        pin = getPin();
        displayHeader("\nBalance after withdrawal:");
        displayBalance(bank, account1, pin);

        displayHeader("");
        accountInfo = getAccountInfo();
        Account account2 = bank.registerCustomer(accountInfo.firstName(), accountInfo.lastName(), accountInfo.pin());
        pin = getPin();
        displayHeader("\nInitial balance of account:");
        displayBalance(bank, account2, pin);

        System.out.println("\nEnter amount to transfer:");
        amount = input.nextInt();
        System.out.println("Enter account number to credit:");
        int destinationAccountNumber = input.nextInt();
        System.out.println("Enter account pin:");
        pin = input.next();
        bank.transfer(account1.getAccountNumber(), destinationAccountNumber, amount, pin);

        pin = getPin();
        displayHeader("\nBalance after transferring urgent 2k:");
        displayBalance(bank, account1, pin);
        pin = getPin();
        displayHeader("\nBalance after receiving urgent 2k:");
        displayBalance(bank, account2, pin);

        System.out.println("\nEnter account number to remove");
        int accountNumber = input.nextInt();
        Account account = bank.findAccount(accountNumber);
        bank.removeAccount(accountNumber, account.getName());

        String output = bank.findAccount(accountNumber) == null ?
                "Account successfully removed." : "Account removal unsuccessful.";
        displayHeader("");
        System.out.printf("%s%n", output);
    }

    private String getPin() {
        System.out.println("\nEnter account pin to check balance:");
        return input.next();
    }

    private static AccountInfo getAccountInfo() {
        System.out.println("Enter first name:");
        String firstName = input.next();

        System.out.println("Enter last name:");
        String lastName = input.next();

        System.out.println("Enter pin:");
        String pin = input.next();

        return new AccountInfo(firstName, lastName, pin);
    }

    private record AccountInfo(String firstName, String lastName, String pin) {
    }

    private static void displayHeader(String header) {
        System.out.println(header);
    }

    private static void displayBalance(Bank bank, Account account, String pin) {
        int balance = bank.checkBalance(account.getAccountNumber(), pin);
        System.out.printf("%s balance: ₦%d%n", account.getName(), balance);
    }
}
