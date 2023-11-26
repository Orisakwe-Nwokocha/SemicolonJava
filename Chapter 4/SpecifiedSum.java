import java.util.Scanner;

public class SpecifiedSum {
	public static void main(String[] args) {

	Scanner input = new Scanner(System.in); 
	
	System.out.print("Enter a number: ");
	int initialNumber = input.nextInt();
	int sum = 0;
	
	while(sum < initialNumber) {
		System.out.print("Enter a number: ");
		int subsequentNumbers = input.nextInt();
		sum += subsequentNumbers;
	}

	System.out.printf("%nThe initial input: %d", initialNumber);
	System.out.printf("%nThe sum of subsequent inputs: %d", sum);
	
	} 
 }