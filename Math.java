import java.util.Scanner;

public class Math{

	public static void main(String[] args){

	Scanner input = new Scanner(System.in);

	System.out.println("Enter First integer:");
	int num1 = input.nextInt();

	System.out.println("Enter Second integer:");
	int num2 = input.nextInt();

	System.out.println("Enter Third integer:");
	int num3 = input.nextInt();

	int sum = num1 + num2 + num3;
	int product = num1 * num2 * num3;
	int average = sum / 3;

	System.out.printf("The sum of the integers is %d%n", sum);
	System.out.printf("The product of the integers is %d%n", product);
	System.out.printf("The average of the integers is %d%n", average);

	
		if (num1 < num2 && num1 < num3) {
		System.out.printf("%d is the smallest number%n", num1);
	}

		else if (num2 < num1 && num2 < num3) {
		System.out.printf("%d is the smallest number%n", num2);
	}

		else  {
		System.out.printf("%d is the smallest number%n", num3);
	}


	
		if (num1 > num2 && num1 > num3) {
		System.out.printf("%d is the largest number%n", num1);
	}

		else if (num2 > num1 && num2 > num3) {
		System.out.printf("%d is the largest number%n", num2);
	}

		else {
		System.out.printf("%d is the largest number%n", num3);
	}


}

}