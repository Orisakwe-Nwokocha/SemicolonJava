import java.util.Scanner;
public class SeparatingDigits {
	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	
	System.out.println("enter a 5 digit number:");
	int num = input.nextInt();
	
	int num1 = num / 10000;
	int num2 = (num % 10000) / 1000;
	int num3 = (num % 1000) / 100;
	int num4 = (num % 100) / 10;
	int num5 = num % 10;

	if (num / 10000 <= 0 || num / 10000 >= 10) {System.out.println(num + " is not a 5 digit number");}
        
	else {
	System.out.printf("%d   %d   %d   %d   %d%n", num1, num2, num3, num4, num5);}


	}
}