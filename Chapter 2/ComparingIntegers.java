import java.util.Scanner;
public class ComparingIntegers {
	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	
	System.out.print("Enter a number: ");
	int num = input.nextInt();
	
	int square = num * num;
	
	if (num > 100 && square > 100)
		System.out.printf("%n%d and %d > 100", num, square);

	if (num == 100 && square == 100)
		System.out.printf("%n%d and %d == 100", num, square);

	if (num != 100 && square != 100)
		System.out.printf("%n%d and %d != 100", num, square);

	if (num < 100 && square < 100)
		System.out.printf("%n%d and %d < 100", num, square);



	}
}