import java.util.Scanner;

public class UserAge {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
	System.out.println("Enter your year of birth: ");
	String userInput = input.nextLine();

	boolean isValid = false;
	int dob = 0;

	while (!isValid){
		try {
			dob = Integer.parseInt(userInput);
			isValid = true;
		}

		catch (NumberFormatException e) {
       	 		System.out.println("Invalid input");

			System.out.println("Enter your year of birth: ");
			userInput = input.nextLine();			
		}
	}

        
	if (dob <= 0 || dob > 2024) System.out.println("Invalid input");
	
        else System.out.printf("%nYou are %d years old%n", (2024 - dob));
    }
}
