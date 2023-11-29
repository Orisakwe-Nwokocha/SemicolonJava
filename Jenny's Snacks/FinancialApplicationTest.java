import java.util.Scanner;

public class FinancialApplicationTest {

public static void main(String[] args) {
	
	FinancialApplication loanApp = 	new FinancialApplication();
	Scanner input = new Scanner(System.in);
	
	System.out.print("Enter loan amount: ");
	int loanAmount = input.nextInt();
	loanApp.setLoanAmount(loanAmount);

	System.out.print("Enter number of years: ");
	int noOfYears = input.nextInt();
	loanApp.setYears(noOfYears);

	System.out.print("Enter interest rate: ");
	int interestRate = input.nextInt();
	loanApp.setInterestRate(interestRate);

	double balance = loanApp.getLoanAmount();

	System.out.printf("%nThe monthly payment: %.2f", loanApp.getMonthlyPayment());
	System.out.printf("%nThe total payment: %.2f", loanApp.getMonthlyPayment() * loanApp.getYears() * 12);
	System.out.printf("%n%nPayment#\t\tInterest\t\tPrincipal\t\tBalance");

	for (int i = 1; i <= loanApp.getYears() * 12; i++) {
		double interest = balance * loanApp.getMonthlyInterestRate();
		double principal = loanApp.getMonthlyPayment() - interest;
		balance = balance - principal;

	System.out.printf("%n%d\t\t\t %.2f\t\t\t %.2f\t\t\t%.2f", i, interest, principal, balance);

	}


   }

}