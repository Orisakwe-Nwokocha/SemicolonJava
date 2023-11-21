import java.util.Scanner;
public class Arithmetic {
	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	
	System.out.print("Enter first number: ");
	int num1 = input.nextInt();
	
	System.out.print("Enter second number: ");
	int num2 = input.nextInt();

	int square1 = num1 * num1;
	int square2 = num2 * num2;
	
	int sum = square1 + square2;
	int difference = square1 - square2;
	
	System.out.printf("%nThe square of each number: %d and %d", square1, square2);
        System.out.printf("%nThe sum of the squares: %d", sum);
 	System.out.printf("%nThe difference of the squares: %d", difference);

	}
}