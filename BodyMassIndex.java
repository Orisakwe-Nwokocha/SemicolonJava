import java.util.Scanner;

public class BodyMassIndex {

	public static void main(String[] args) {
 	
	Scanner input = new Scanner(System.in);
 	
	System.out.println("Enter weight in pounds: ");  
	float pounds = input.nextFloat();
	
	System.out.println("Enter height in inches: ");  
	float inches = input.nextFloat();

	double kilogram = pounds * 0.45359237;
	double metres = inches * 0.0254;
	
	double BMI = kilogram / (metres * metres); 

		
		System.out.printf("BMI is %.4f%n", BMI); 

	
	
 	
 } 
}
