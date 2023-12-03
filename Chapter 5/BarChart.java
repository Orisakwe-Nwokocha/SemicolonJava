import java.util.Scanner;

public class BarChart {

	public static void main(String[] args) {

	Scanner input = new Scanner(System.in);

	
	int num1 = 0;
	int num2 = 0;
	int num3 = 0;
	int num4 = 0;
	int num5 = 0;

	System.out.println("Enter 5 set of numbers: 1-30");	

	while (true) {
		System.out.print("Enter number 1: ");	
		num1 = input.nextInt();
		while (num1 < 1 || num1 > 30){
			System.out.println("Invalid input. Enter a number from 1-30");
			System.out.printf("Enter number 1: ");
			num1 = input.nextInt();
		}
		
		System.out.print("Enter number 2: ");	
		num2 = input.nextInt();
		while (num2 < 1 || num2 > 30){
			System.out.println("Invalid input. Enter a number from 1-30");
			System.out.printf("Enter number 2: ");
			num2 = input.nextInt();
		}

		System.out.print("Enter number 3: ");	
		num3 = input.nextInt();
		while (num3 < 1 || num3 > 30){
			System.out.println("Invalid input. Enter a number from 1-30");
			System.out.print("Enter number 3: ");
			num3 = input.nextInt();
		}

		System.out.print("Enter number 4: ");	
		num4 = input.nextInt();
		while (num4 < 1 || num4 > 30){
			System.out.println("Invalid input. Enter a number from 1-30");
			System.out.print("Enter number 4: ");
			num4 = input.nextInt();
		}

		System.out.print("Enter number 5: ");	
		num5 = input.nextInt();
		while (num5 < 1 || num5 > 30){
			System.out.println("Invalid input. Enter a number from 1-30");
			System.out.printf("Enter number 5: ");
			num5 = input.nextInt();
		}
		break;
	
	}
	
	System.out.println();

	for (int i = 1; i <= num1; i++) {

		System.out.print("*");
	}
		System.out.println();

	for (int i = 1; i <= num2; i++) {

		System.out.print("*");
	}

		System.out.println();

	for (int i = 1; i <= num3; i++) {

		System.out.print("*");
	}

		System.out.println();

	for (int i = 1; i <= num4; i++) {

		System.out.print("*");
	}

		System.out.println();

	for (int i = 1; i <= num5; i++) {

		System.out.print("*");
	}

   }

}
