import java.util.Scanner;

public class AccountModifiedTest {
	public static void main(String[] args) {
	
	AccountModified account1 = new AccountModified("Jane Green", 50.00);
	AccountModified account2 = new AccountModified("John Blue", -7.53);

	Scanner input = new Scanner(System.in);

	displayAccount(account1);
	displayAccount(account2);
	
	System.out.printf("%nEnter deposit amount for account1: ");
	double depositAmount = input.nextDouble();
	System.out.printf("%nadding %.2f to account1 balance%n%n", depositAmount);
	account1.deposit(depositAmount);

	displayAccount(account1);
	displayAccount(account2);
	
	System.out.printf("%nEnter deposit amount for account2: ");
	depositAmount = input.nextDouble();	
	System.out.printf("%nadding %.2f to account2 balance%n%n", depositAmount);
	account2.deposit(depositAmount);

	displayAccount(account1);
	displayAccount(account2);

	System.out.printf("%nEnter withdrawal amount for account1: ");
	double withdrawalAmount = input.nextDouble();
	System.out.printf("%nsubtracting %.2f from account1 balance%n%n", withdrawalAmount);
	account1.withdraw(withdrawalAmount);

	displayAccount(account1);
	displayAccount(account2);

	System.out.printf("%nEnter withdrawal amount for account2: ");
	withdrawalAmount = input.nextDouble();
	System.out.printf("%nsubtracting %.2f from account2 balance%n%n", withdrawalAmount);
	account2.withdraw(withdrawalAmount);

	displayAccount(account1);
	displayAccount(account2);

	}
	
	public static void displayAccount(AccountModified objectName) {
		System.out.printf("%s balance: $%.2f%n", objectName.getName(), objectName.getBalance());
	}
}