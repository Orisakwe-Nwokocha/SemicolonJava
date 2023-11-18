import java.util.Scanner;
public class SumAllDigitsLoop {
	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	
	System.out.println("Enter a number between 0 and 1000");
	int num = input.nextInt();
	int i;
	int sum = 0;
	while (num < 1 || num > 999) {
		System.out.println("Invalid input. Please enter a number from 1 to 999:");
		num = input.nextInt();
	}

	if (num < 10) {
		System.out.println(num);
	}

	while (num > 0) {
            sum = sum + num % 10;
            num = num / 10;
        }

	

       System.out.println(sum);


	}
}