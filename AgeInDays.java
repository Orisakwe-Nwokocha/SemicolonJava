import java.util.Scanner;
public class AgeInDays {
	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	
	System.out.println("Enter your age");
	int num = input.nextInt();
	
	while (num < 0) {
		System.out.println("Invalid input. Please enter a number >= 0:");
		num = input.nextInt();
	}
	
	long converted = num * 365;
	
	System.out.println(converted);
       

	}
}