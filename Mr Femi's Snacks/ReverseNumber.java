import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
	System.out.println("Enter a five digit number: ");
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

			System.out.println("Enter a five digit number: ");
			userInput = input.nextLine();			
		}
	}

        
	if (number < 10000 || number > 99999) System.out.println("Invalid input");
	
        else {
		String reversedNumber = "";

		for (int count = 0; count < 5; count++) {
			reversedNumber += number % 10;
			number /= 10; 
		}
		
		System.out.printf("%n%s in reverse is: %s%n", userInput, reversedNumber);
	} 
	
    }
}
