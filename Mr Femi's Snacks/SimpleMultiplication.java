import java.util.Scanner;

public class SimpleMultiplication {

	public static void main(String[] args) {

	Scanner input = new Scanner(System.in);

	System.out.print("Enter a number from 1-10: ");
	int userInput = input.nextInt();
	int result = 1;
	int counter = 1;


	if (userInput < 1 || userInput > 10) {
		System.out.printf("%nInvalid input");
		
	}
	
	else {
		System.out.println();
		while (counter <= 12) {
			result = userInput * counter;
			System.out.printf("%d * %d = %d%n", userInput, counter, result);
			counter++;
	}
}

   }

}