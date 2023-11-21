import java.util.Scanner;
public class DigitToWords {
	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	
	System.out.println("Enter a number: 0-10: ");
	int num = input.nextInt();
	
	while (num < 0 || num > 10) {
	
		System.out.println("Enter a number from 0-10:");
		num = input.nextInt();
	}
	
	if (num == 0) {
		System.out.println("Zero");
	}
	if (num == 1) 
		System.out.println("One");
        
	if (num == 2) 
		System.out.println("Two");
        
	if (num == 3) 
		System.out.println("Three");
        
	if (num == 4) 
		System.out.println("Four");
        
	if (num == 5) 
		System.out.println("Five");

	if (num == 6) 
		System.out.println("Six");
        
	if (num == 7) 
		System.out.println("Seven");
        
	if (num == 8) 
		System.out.println("Eight");
        
	if (num == 9) 
		System.out.println("Nine");
        
	if (num == 10)
		System.out.println("Ten");



	}
}