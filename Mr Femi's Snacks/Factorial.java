import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
	System.out.println("Enter a number between 1 and 20: ");
	String userInput = input.nextLine();

	boolean isValid = false;
	long number = 0;

	while (!isValid){
		try {
			number = Long.parseLong(userInput);
			isValid = true;
		}

		catch (NumberFormatException e) {
       	 		System.out.println("\nInvalid input");

			System.out.println("Enter a number: ");
			userInput = input.nextLine();			
		}
	}

        
	if (number <= 0 || number > 20) System.out.println("Invalid input");
	
        else {
		System.out.printf("%d factorial ===> %d", number, number);

		for (long count = number - 1; count >= 1; count--) {
			System.out.printf(" * %d", count);
			number *= count;
		}

		System.out.printf(" = %d", number);
	} 	
	
    }
}
