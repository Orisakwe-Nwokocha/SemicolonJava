import java.util.Scanner;

public class Celsius2 {

	public static void main(String[] args) {
 	Scanner input = new Scanner(System.in);
	System.out.println("Enter a floating point number");

 	float celsius = input.nextFloat();
	float fahrenheit = (celsius * 9 / 5) + 32;
 	
		System.out.printf("%f°",  fahrenheit);
 
 	
 } 
}
