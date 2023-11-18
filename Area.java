import java.util.Scanner;

public class Area {

	public static void main(String[] args) {
 	Scanner input = new Scanner(System.in);

 	System.out.print("Enter first radius: ");  
	int radius = input.nextInt();

 	double π = 3.14159;
	int r = radius;
	double diameter = 2 * r;
	double circumference = 2 * π * r;
 	double area  = π * r * r;
		System.out.printf("diameter = %f%ncircumference = %f%narea = %f", diameter, circumference, area);
 
 	
 } 
}

