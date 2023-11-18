import java.util.Scanner;

public class InterestRate {

	public static void main(String[] args) {
 	
	Scanner input = new Scanner(System.in);
 	
	System.out.println("Enter first integer: ");  
	int balance = input.nextInt();

	System.out.println("Enter second integer: ");  
	float annualInterestRate = input.nextFloat();

		

	double interest = balance * (annualInterestRate / 1200);
		
		System.out.printf("%.5f%n", interest);

	
	
 	
 } 
}
