import java.util.Scanner;

public class DecimalEquivalent {
	public static void main(String[] args) {

	Scanner input = new Scanner(System.in); 
	
	int binary, digits, decimal = 0, power = 0;  	
	
	System.out.print("Enter a binary number: ");
	binary = input.nextInt();
	
	System.out.printf("%nThe decimal equivalent of %d binary number is ", binary);
	
	while (binary > 0) {
		digits = binary % 10;
		binary = binary / 10;
		decimal += digits * Math.pow(2, power);
		power++;
	}
	
	System.out.print(decimal);
	
	/*
	System.out.print("Enter a number: ");
	int num = input.nextInt();
	int sum = 0;
	
	while(num > 0) {
		sum += num % 10;
		num = num / 10;
	}

	// System.out.printf("%nThe initial input: %d", initialNumber);
	System.out.printf("%nThe sum of individual digits: %d", sum); */
	
	
	
	
	
	
	} 
 }