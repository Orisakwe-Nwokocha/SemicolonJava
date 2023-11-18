import java.util.Scanner;
public class SumAllDigits {
	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	
	System.out.println("Enter a number between 0 and 1000");
	int num = input.nextInt();
	
	while (num < 1 || num > 999) {
		System.out.println("Invalid input. Please enter a number from 1 to 999:");
		num = input.nextInt();
	}

	if (num < 10) {
		System.out.println(num);
	}

	if (num >= 10 && num < 100) {
		int num1 = num % 10;
		int num2 = num / 10;
		int num3 = num1 + num2;
		System.out.println(num3);
	}

	if (num >= 100 && num < 1000) {
		int num4 = num / 100;
		int num5 = (num / 10) % 10;
		int num6 = num % 10;
		int num7 = num4 + num5+ num6;
		System.out.println(num7);
	}

        // System.out.println("");


	}
}