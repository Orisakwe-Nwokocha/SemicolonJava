package oopAccount;

public class BankApp {
    private Bank bank;

    public void main() {
        bank = new Bank("First Bank of Nigeria PLC");

        Account johnDoe = bank.registerCustomer("John", "Doe", "1234");
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
        bank.removeAccount(janeDoe.getAccountNumber(), janeDoe.getName());

        String output = bank.findAccount(accountNumber) == null ?
                "Account successfully removed." : "Account removal unsuccessful.";
        displayHeader("");
        System.out.printf("%s%n", output);
    }

    private static void displayHeader(String header) {
        System.out.println(header);
    }

    private static void displayBalance(Bank bank, Account account, String pin) {
        int balance = bank.checkBalance(account.getAccountNumber(), pin);
        System.out.printf("%s balance: ₦%d%n", account.getName(), balance);
    }
}