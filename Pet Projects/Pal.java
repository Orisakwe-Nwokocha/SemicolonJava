import java.util.Scanner;
public class Pal {
	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	
	System.out.println("enter a 3 digit num");
	int num = input.nextInt();

	int num2 = num / 100;
	int num3 = (num / 10) % 10;
	int num4 = num % 10;
	
	String append = num4 + "" + num3 + "" + num2;
	int num5 = Integer.parseInt(append);
	
	if (num5 == num)
		System.out.println("true");
	else
		System.out.println("false");       


	}
}