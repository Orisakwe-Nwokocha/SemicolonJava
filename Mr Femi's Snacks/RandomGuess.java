import java.security.SecureRandom;
import java.util.Scanner;

public class RandomGuess {

	public static void main(String[] args) {

	Scanner input = new Scanner(System.in);
	SecureRandom random = new SecureRandom();

	int lottery = random.nextInt(1, 11);
	System.out.print("Guess a number from 1-10: ");
	int guess = input.nextInt();

	while (guess < 1 || guess > 10) {
		System.out.print("Invalid input. Guess a number from 1-10: ");
		guess = input.nextInt();
	}

	if (guess < lottery) {
		System.out.printf("%nToo low: Random number = %d || Your guess = %d%n", lottery, guess);
	}

	if (guess == lottery) {
		System.out.printf("%nCorrect: Random number = %d || Your guess = %d%n", lottery, guess);
	}

	if (guess > lottery) {
		System.out.printf("%nToo high: Random number = %d || Your guess = %d%n", lottery, guess);
	}


   }

}