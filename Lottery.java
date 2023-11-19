import java.util.Scanner;
import java.util.Random;

public class Lottery {

	public static void main(String[] args){

	Scanner input = new Scanner(System.in);
	Random rand = new Random();

	System.out.println("Enter a three digit number: (e.g 123, 231, 321): ");
	int userInput = input.nextInt();
	
	int randomNumber = rand.nextInt(1000) + 100;
	
	int sep1 = randomNumber / 100;
	int sep2 = (randomNumber / 10) % 10;
	int sep3 = randomNumber % 10;
	int sumRand = sep1 + sep2 + sep3;
	
	int sep4 = userInput / 100;
	int sep5 = (userInput / 10) % 10;
	int sep6 = userInput % 10; 
	int sumUserInput = sep4 + sep5 + sep6;

	System.out.println("Generated number is: "+ randomNumber);

	if (userInput == randomNumber && sumUserInput == sumRand) {
		System.out.println("You won $10,000");
	}	
	
	else if (sep4 == sep1 || sep4 ==  sep2 || sep4 ==  sep3) {
		if (sep5 == sep1 || sep5 ==  sep2 || sep5 ==  sep3) {
			if (sep6 == sep1 || sep6 ==  sep2 || sep6 ==  sep3) {
				if (sumUserInput == sumRand) {
					System.out.println("You won $3,000");
				}	
			}
		}

	}
	
	if (sep4 == sep1 || sep4 == sep2 || sep4 == sep3 || sep5 == sep1 || sep5 == sep2 || sep5 == sep3 || sep6 == sep1 || sep6 == sep2 || sep6 == sep3) {
		if (sumUserInput != sumRand) {
			System.out.println("You won $1,000");
		}
	}
	
	else if (userInput != randomNumber && sumUserInput != sumRand) {
		System.out.println("You lost. Try again!!!");
	}






	}

}