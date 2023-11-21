import java.util.Scanner;

public class Area {

	public static void main(String[] args) {
 	Scanner input = new Scanner(System.in);

 	System.out.print("Enter radius: ");  
	int radius = input.nextInt();
	
 	System.out.printf("Diameter = %d%n", (2 * radius));
	System.out.printf("Circumference = %f%n", (2 * 3.14159 * radius));
	System.out.printf("Area = %f%n", (3.14159 * radius * radius));
 	
 } 
}

