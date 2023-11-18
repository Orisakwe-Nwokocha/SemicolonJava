import java.util.Scanner;

public class Accel {

	public static void main(String[] args) {
 	
	Scanner input = new Scanner(System.in);
 	
	System.out.println("Enter starting velocity: ");  
	
	float v0 = input.nextFloat();

	System.out.println("Enter ending velocity: ");  
	float v1 = input.nextFloat();
	
 	System.out.println("Enter time span: ");  
	float timeSpan = input.nextFloat();

	float acceleration = (v1 - v0) / timeSpan;
		
		System.out.printf("The average accelleration is  %.4f%n", acceleration);

	
	
 	
 } 
}
