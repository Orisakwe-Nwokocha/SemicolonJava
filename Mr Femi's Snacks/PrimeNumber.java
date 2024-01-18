import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
	System.out.println("Enter a number: ");
	String userInput = input.nextLine();

	boolean isValid = false;
	int number = 0;

	while (!isValid){
		try {
			number = Integer.parseInt(userInput);
			isValid = true;
		}

		catch (NumberFormatException e) {
       	 		System.out.println("\nInvalid input");

			System.out.println("Enter a number: ");
			userInput = input.nextLine();			
		}
	}

        
	if (number <= 0) System.out.println("Invalid input");
	
        else {
		int counter = 0;

		for (int count = 1; count <= number; count++) {
			if (number % count == 0) counter++;
		}
		
		if (counter == 2) System.out.printf("%n%d is a prime number%n", number);
		else System.out.printf("%n%d is not a prime number%n", number);
	} 
	
    }
}
