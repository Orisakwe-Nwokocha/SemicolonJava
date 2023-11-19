import java.util.Scanner;
import java.util.Random;

public class HeadsOrTails {

	public static void main(String[] args){

	Scanner input = new Scanner(System.in);
	Random rand = new Random();

	System.out.println("Coin Toss: (heads = 0, tail = 1):");
	int userInput = input.nextInt();

	int randomNumber = rand.nextInt(2) + 0;

	while (userInput < 0 || userInput > 1) {
		System.out.println("Invalid input. Please enter either 0 or 1 (heads = 0, tail = 1):");
		userInput = input.nextInt();
	}

	System.out.println("Generated number is: "+ randomNumber);

	if (userInput == randomNumber)
		System.out.println("Your guess is correct!!!");
	
	else
		System.out.println("Your guess is incorrect!!!");

	}

}