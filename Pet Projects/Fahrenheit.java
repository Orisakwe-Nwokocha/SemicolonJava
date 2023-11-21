import java.util.Scanner;

public class Fahrenheit {

	public static void main(String[] args) {
 	Scanner input = new Scanner(System.in);
	System.out.print("Enter a floating point number: ");

 	float fahrenheit = input.nextFloat();
	float celsius = (fahrenheit - 32) * 5 / 9;
	
 	
		System.out.printf("%f°",  celsius);
 
 	
 } 
}

