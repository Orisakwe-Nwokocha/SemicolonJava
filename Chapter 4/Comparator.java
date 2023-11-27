import java.util.Scanner;

public class Comparator {
	public static void main(String[] args) {

	Scanner input = new Scanner(System.in);
	
	System.out.print("Enter first number: ");
	int num1 = input.nextInt();
	System.out.print("Enter first number: ");
	int num2 = input.nextInt();
	
	if (num1 == num2) {
		System.out.print("0");
	}
	
	if (num1 > num2) {
		System.out.print("1");
	}
	
	if (num1 < num2) {
		System.out.print("-1");
	}		
	
		
		
	} 
 }