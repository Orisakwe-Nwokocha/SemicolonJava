import java.security.SecureRandom;
import java.util.Scanner;

public class GuessTheNumber {

   public static void main(String[] args) {

	Scanner input = new Scanner(System.in);
	SecureRandom random = new SecureRandom();

	int lottery = random.nextInt(1, 1001);
	System.out.print("Guess a number between 1 and 1000: ");
	int guess = input.nextInt();
	String userChoice = "";

	while (guess < 1 || guess > 1000) {
		System.out.print("Invalid input. Guess a number between 1 and 1000: ");
		guess = input.nextInt();
	}

	while (true) {
		while (guess != lottery) {
			if (guess < lottery) {
				System.out.printf("%nToo low. Try again%n%n");
			}

			if (guess > lottery) {
				System.out.printf("%nToo high. Try again%n%n");
			}

			System.out.print("Guess a number between 1 and 1000: ");
			guess = input.nextInt();

			while (guess < 1 || guess > 1000) {
				System.out.print("Invalid input. Guess a number between 1 and 1000: ");
				guess = input.nextInt();
			}
		}

        System.out.printf("%nCongratulations. You guessed the number!%n%n");

		System.out.println("Do you want to play again (y/n)?");
		userChoice = input.next();

		if (userChoice.equalsIgnoreCase("y")) {
			lottery = random.nextInt(1, 1001);
			System.out.print("\nGuess a number between 1 and 1000: ");
			guess = input.nextInt();

			while (guess < 1 || guess > 1000) {
				System.out.print("Invalid input. Guess a number between 1 and 1000: ");
				guess = input.nextInt();
			}
		}

		else {
			break;
		}

	}

    }

}
