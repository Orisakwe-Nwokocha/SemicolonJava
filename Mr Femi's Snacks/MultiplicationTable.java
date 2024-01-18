import java.util.Scanner;

public class MultiplicationTable {
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
		for (int multiply = 1; multiply <= 12; multiply++) {
			System.out.printf("%d * %d = %d%n", multiply, number, (multiply * number));
		}
	} 
	
    }
}
