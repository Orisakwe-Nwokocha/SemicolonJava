import java.util.Scanner;

public class CostOfDriving {

	public static void main(String[] args) {
 	
	Scanner input = new Scanner(System.in);
 	
	System.out.println("Enter the driving distance: ");  
	float drivingDistance = input.nextFloat();
	
	System.out.println("Enter miles per gallon: ");  
	float milesPerGallon = input.nextFloat();
	
	System.out.println("Enter price per gallon: ");  
	float pricePerGallon = input.nextFloat();
	
	float distanceCost = drivingDistance * (pricePerGallon / milesPerGallon); 

		
		System.out.printf("The cost of driving is $%.2f%n", distanceCost); 

	
	
 	
 } 
}
