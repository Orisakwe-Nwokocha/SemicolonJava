import java.util.Scanner;

public class WeightConversion {

	public static void main(String[] args) {
 	
	Scanner input = new Scanner(System.in);
 	
	System.out.println("Enter a number in pounds: ");  
	float pound = input.nextFloat();

	double kilogram = pound * 0.454;
	
		System.out.printf("%.3f pounds is %.3f kilograms%n", pound, kilogram); 

	
	
 	
 } 
}
