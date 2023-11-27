import java.util.Scanner;
public class Cryptography {
	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	
	System.out.printf("Enter a 4 digit number: ");
	int num = input.nextInt();

	while (num < 1000 || num > 9999) {
		System.out.println(num + " is not a 4 digit number");
		num = input.nextInt();	
		}
		
	int num1 = ((num / 1000) + 7) % 10;
	int num2 = (((num % 1000) / 100) + 7) % 10;
	int num3 = (((num % 100) / 10) + 7) % 10;
	int num4 = ((num % 10) + 7) % 10;
	
	System.out.printf("%n%d %d %d %d", num1, num2, num3, num4);
	String append = num3 + "" + num4 + "" + num1 + "" + num2;
	
	
	System.out.printf("%nThe encrypted value of %d is %s", num, append);
		

	
			

		


	}
}