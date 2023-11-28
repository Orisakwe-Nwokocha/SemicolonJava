import java.util.Scanner;
public class AccountNewTest {
	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	
	System.out.println("Welcome to Mavericks Bank");
	
	AccountNew account = new AccountNew();

	System.out.printf("%nEnter your id: ");
	int userId = input.nextInt();
	account.setId(userId);

	System.out.printf("%nEnter your initial balance: ");
	double initialBalance = input.nextDouble();
	account.setBalance(initialBalance);

	System.out.printf("%nEnter annual interest rate: ");
	double annualIntRate = input.nextDouble();
	account.setAnnualInterestRate(annualIntRate);

	System.out.printf("%nEnter date created: ");
	String dateOfCreation = input.next();	
 
	
	System.out.printf("%nWould you like to withdraw: yes/no: ");
	String prompt = input.next();
	
	if (prompt.equalsIgnoreCase("yes")) {
		System.out.printf("%nEnter withdraw amount: ");
		double withdrawAmount = input.nextDouble();
		account.withdraw(withdrawAmount);
			
		System.out.printf("%nWould you like to deposit: yes/no: ");
		String prompt2 = input.next();
			
		if (prompt2.equalsIgnoreCase("yes")) {
			System.out.printf("%nEnter depsoit amount: ");
			double depAmount = input.nextDouble();
			account.deposit(depAmount);
			
			System.out.printf("%nYour new balance: %.3f%n", account.getBalance());
	
			System.out.printf("%nThank you for banking with us!!!%n");

			System.out.printf("%nYour monthly interest is: %.3f%n", account.getMonthlyInterest());
		}
			
		if (prompt2.equalsIgnoreCase("no")){
				System.out.printf("%nYour new balance: %.3f%n", account.getBalance());
	
				System.out.printf("%nThank you for banking with us!!!%n");

				System.out.printf("%nYour monthly interest is: %.3f%n", account.getMonthlyInterest());
				}
		}
		

	if (prompt.equalsIgnoreCase("no")) {
		System.out.printf("%nWould you like to deposit: yes/no: ");
		String prompt3 = input.next();
			
		if (prompt3.equalsIgnoreCase("yes")) {
			System.out.printf("%nEnter depsoit amount: ");
			double depAmount = input.nextDouble();
			account.deposit(depAmount);
			
			System.out.printf("%nYour new balance: %.3f%n", account.getBalance());
	
			System.out.printf("%nThank you for banking with us!!!%n");

			System.out.printf("%nYour monthly interest is: %.3f%n", account.getMonthlyInterest());

		}

		if (prompt3.equalsIgnoreCase("no")) {
			System.out.printf("%nYour new balance: %.3f%n", account.getBalance());
	
			System.out.printf("%nYour monthly interest is: %.3f%n", account.getMonthlyInterest());

			System.out.printf("%nThank you for banking with us!!!%n");
			}
	}
		
	



	}
}