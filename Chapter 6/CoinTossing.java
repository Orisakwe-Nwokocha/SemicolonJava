import java.security.SecureRandom;
import java.util.Scanner;

public class CoinTossing {
    private static final SecureRandom randomNumbers = new SecureRandom();
    private static final Scanner input = new Scanner(System.in);
    private static Coin flippedCoin;
	
    public static void main(String... args) {
	
	int heads = 0;
	int tails = 0;
	int total = 0;
	
	System.out.println("""
			1. Toss Coin
			2. End Program""");

	System.out.println("\nEnter 'y' to toss coin || or any other key to end program:");
	String userChoice = input.next();	

	while (userChoice.equalsIgnoreCase("Y")) {

		flip();

		if (flippedCoin == Coin.HEADS) {
			heads++;
		}

		if (flippedCoin == Coin.TAILS) {
			tails++;
		}
		
		total++;

		System.out.println();
		System.out.println("""
			1. Toss Coin
			2. End Program""");

	System.out.println("\nEnter 'y' to toss coin || or any other key to end program:");
	userChoice = input.next();


	}

	if (heads > 0 || tails > 0) {
		System.out.println("The total number of coins flipped is: " + total);
		System.out.println("The number of times that heads appeared is: " + heads);
		System.out.println("The number of times that tails appeared is: " + tails);
	}

	else {
				System.out.println("No coin was tossed");	
	}


    }

    public static Coin flip() {

	int coinToss = randomNumbers.nextInt(0, 2);
	
	switch (coinToss) {

		case 0: 
			flippedCoin = Coin.HEADS; 
			System.out.println("\nThe coin flipped is: " + flippedCoin);
			break;

		case 1: flippedCoin = Coin.TAILS;
			System.out.println("\nThe coin flipped is: " + flippedCoin);
			break;
	}
	
	return flippedCoin;

    }

    private enum Coin {HEADS, TAILS};




}