import java.util.Scanner;

public class Celsius {

	public static void main(String[] args) {
 	Scanner input = new Scanner(System.in);
	System.out.println("Enter a degree in celsius:");

 	double celsius = input.nextDouble();
	double fahrenheit = (celsius * 9 / 5) + 32;
 	
		System.out.printf("%.1f°C = %.1f°F", celsius, fahrenheit);
 
 	
 } 
}
