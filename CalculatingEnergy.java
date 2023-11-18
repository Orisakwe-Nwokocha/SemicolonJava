import java.util.Scanner;

public class CalculatingEnergy {

	public static void main(String[] args) {
 	
	Scanner input = new Scanner(System.in);
 	
	System.out.println("Enter amount of water (kg): ");  
	float water = input.nextFloat();

	System.out.println("Enter initial temperature: ");  
	float initialTemperature = input.nextFloat();
	
 	System.out.println("Enter time span: ");  
	float finalTemperature = input.nextFloat();

	float energy = water * (finalTemperature - initialTemperature) * 4184;
		
		System.out.printf("%.2f%n", energy);

	
	
 	
 } 
}
