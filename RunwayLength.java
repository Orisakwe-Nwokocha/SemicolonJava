import java.util.Scanner;

public class RunwayLength {

	public static void main(String[] args) {
 	
	Scanner input = new Scanner(System.in);
 	
	System.out.println("Enter speed (m/s): ");  
	float v_speed = input.nextFloat();

	System.out.println("Enter acceleration (m/s): ");  
	float a_acceleration = input.nextFloat();
	
 	
	double length = (v_speed * v_speed) / (2 * a_acceleration); 
		
		System.out.printf("The minimum runway length for this airplane is %.3f%n", length);

	
	
 	
 } 
}
