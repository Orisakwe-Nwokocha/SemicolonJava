import java.util.Scanner;

public class FutureInvestmentValue {

	public static void main(String[] args) {
 	
	Scanner input = new Scanner(System.in);
 	
	System.out.println("Enter investment amount: ");  
	float investmentAmount = input.nextFloat();

	System.out.println("Enter annual interest rate: ");  
	float annualInterestRate = input.nextFloat();
	
	System.out.println("Enter number of years: ");  
	int noOfYears = input.nextInt();
	int yearlyExponent = noOfYears * 12;

	double monthlyInterestRate = annualInterestRate / 1200;

double futureInvestment = investmentAmount * Math.pow((1 + monthlyInterestRate), yearlyExponent);  
		
		System.out.printf("Accumulated value is %.2f%n", futureInvestment);

	
	
 	
 } 
}
