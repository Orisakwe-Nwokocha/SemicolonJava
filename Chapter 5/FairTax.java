import java.util.Scanner;

public class FairTax {

	public static void main(String[] args) {

	Scanner input = new Scanner(System.in);

	System.out.print( "Enter your housing expenses: " );
	double housing = input.nextDouble();

	System.out.print( "Enter your food expenses: " );
	double food = input.nextDouble();

	System.out.print( "Enter your clothing expenses: " );
	double clothing = input.nextDouble();

	System.out.print( "Enter your transportation expenses: " );
	double transportation = input.nextDouble();

	System.out.print( "Enter your education expenses: " );
	double education = input.nextDouble();

	System.out.print( "Enter your healthcare expenses: " );
	double healthcare = input.nextDouble();

	System.out.print( "Enter your vacations expenses: " );
	double vacations = input.nextDouble();

	double totalExpenses = housing + food + clothing + transportation + education + healthcare + vacations;

	double fairTax = totalExpenses * 0.3;

	System.out.printf("%nYour total expenses is: $%.3f%n", totalExpenses);
	System.out.printf("Your estimated fair tax is: $%.3f%n", fairTax);




   }

}