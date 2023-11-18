import java.util.Scanner;
public class Fact {
	public static void main(String[] args) {

	Scanner userInput = new Scanner(System.in);
	
	System.out.println("Enter a number");
	int num = userInput.nextInt();
	int a;
	boolean prime = true;
	
			 if (num <= 1) {
				prime = false; 
				
			}

			
	// System.out.print("the factors of " + num + "are: ");
	for (a = 2; a <= num / 2; a++) {
		
			

		if (num % a == 0) {
			prime = false;
			break;
		}
	
	}
	if (prime)
		System.out.println(num + " is  a prime number");
	else
		System.out.print(num + " is not a prime number");

}

}