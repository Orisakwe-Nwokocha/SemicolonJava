import java.util.Scanner;
public class Palindromes {
	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	
	

	while (true) {
		
		System.out.printf("Enter a 5 digit number: ");
		int num = input.nextInt();
		int num1 = num / 10000;
		int num2 = (num % 10000) / 1000;
		int num3 = (num % 1000) / 100;
		int num4 = (num % 100) / 10;
		int num5 = num % 10;
	
		String append = num5 + "" + num4 + "" + num3 + "" + num2 + "" + num1;
		int num6 = Integer.parseInt(append);
		
		if (num / 10000 <= 0 || num / 10000 >= 10) {
			System.out.println(num + " is not a 5 digit number");		
		}

		else if (num6 == num) {
			System.out.printf("%n%d is a palindrome%n", num);
			break;	
		}
		
		else if (num6 != num) {
			System.out.printf("%n%d is not a palindrome%n", num);	
			break;	
		} 	
	}	

	
			

		


	}
}