import java.util.Scanner;

public class BitFlipper {
	
	public static void main(String[] args) {
 	
		Scanner input = new Scanner(System.in);
 	
	System.out.println("Enter a number"); 

	int userInput = input.nextInt();
	int flip0 = 1;
	int flip1 = 0;

	if (userInput == 0) {
	
	System.out.println(flip0); 
	}

	if (userInput == 1) {
	
	System.out.println(flip1); 
	}

}
}