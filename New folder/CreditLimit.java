import java.util.Scanner;
public class CreditLimit {
	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	
	System.out.print("Do you want to enter a customer account: y/n?: ");
	String choice = input.next();

	while (choice.equalsIgnoreCase("y")) {
		System.out.print("Enter customer account number: ");
		int accountNumber = input.nextInt();

		System.out.print("Enter customer initial balance: ");
		int balance = input.nextInt();

		System.out.print("Enter customer total charges: ");
		int totalCharges = input.nextInt();

		System.out.print("Enter customer total credits: ");
		int totalCredits = input.nextInt();

		System.out.print("Enter customer allowed credit limit: ");
		int allowedCreditLimt = input.nextInt();
	
		int newBalance = (balance + totalCharges) - totalCredits;
		System.out.printf("%nCustomer %d new balance: %d%n%n", accountNumber, newBalance);
		
		if (newBalance > allowedCreditLimt) {
			System.out.printf("Credit limit exceeded for customer %d%n%n", accountNumber);
		}

		System.out.print("Do you want to enter a customer account: y/n?: ");
		choice = input.next();
	}

	
 

	}
}