import java.security.SecureRandom;
import java.util.Scanner;

public class GuessTheNumberModification {
	private static final SecureRandom random = new SecureRandom();

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);


		int lottery = random.nextInt(1, 1001);
		int count = 1;

		System.out.println("Guess a number between 1 and 1000:");
		int guess = input.nextInt();

		while (true) {
			while (guess < 1 || guess > 1000) {
				System.out.println("Invalid input. Guess a number between 1 and 1000:");
				guess = input.nextInt();
			}

			while (guess != lottery) {
				if (guess < lottery) {
					System.out.printf("%nToo low. Try again%n");
				}

				if (guess > lottery) {
					System.out.printf("%nToo high. Try again%n");
				}

				System.out.println(getChatter() + "\n");

				count++;

				System.out.println("Guess a number between 1 and 1000:");
				guess = input.nextInt();

				while (guess < 1 || guess > 1000) {
					System.out.println("Invalid input. Guess a number between 1 and 1000:");
					guess = input.nextInt();
				}
			}

			System.out.printf("%nCongratulations. You guessed the number!%n");
			System.out.println("It took you " + count + " tries!");

			if (count < 10) {
				System.out.printf("Either you know the secret or you got lucky!%n%n");
			} else if (count == 10) {
				System.out.printf("Aha! You know the secret!%n%n");
			} else {
				System.out.printf("You should be able to do better!%n%n");
			}

			System.out.println("Do you want to play again (y/n)?");
			String userChoice = input.next();

			if (userChoice.equalsIgnoreCase("y")) {
				lottery = random.nextInt(1, 1001);
				count = 1;
				System.out.println("\nGuess a number between 1 and 1000:");
				guess = input.nextInt();

				while (guess < 1 || guess > 1000) {
					System.out.println("Invalid input. Guess a number between 1 and 1000:");
					guess = input.nextInt();
				}
			} else {
				break;
			}

        }

	}

	public static String getChatter() {
		String chatter = "";
		int chatterNumber = random.nextInt(1, 8);

		switch (chatterNumber) {
			case 1 -> chatter = "You are getting warmer";
			case 2 -> chatter = "You wish you were close :)";
			case 3 -> chatter = "Oga, nothing for you";
			case 4 -> chatter = "You sef don try";
			case 5 -> chatter = "Lottery is not your thing";
			case 6 -> chatter = "Better go find work, madam";
			case 7 -> chatter = "Keep going";
		}
		return chatter;
	}

}
