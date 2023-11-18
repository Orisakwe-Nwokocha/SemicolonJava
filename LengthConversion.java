import java.util.Scanner;

public class LengthConversion {

	public static void main(String[] args) {
 	
	Scanner input = new Scanner(System.in);
 	
	System.out.println("Enter a value for feet: ");  
	float feet = input.nextFloat();

	double metres = feet * 0.305;
	
		System.out.printf("%.4f feet is %.4f metres%n", feet, metres); 

	
	
 	
 } 
}
