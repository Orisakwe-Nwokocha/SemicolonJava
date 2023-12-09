import java.util.Scanner;
public class Cryptography {
	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	
	System.out.printf("Enter a 4 digit number: ");
	String cast = input.nextLine();
	int length = cast.length();
	
	while (length != 4) {
		System.out.println(cast + " is not a 4 digit number");
		System.out.printf("Enter a 4 digit number: ");
		cast = input.nextLine();
		length = cast.length();		
	}
	
	char a = cast.charAt(0);
	char b = cast.charAt(1); 
	char c = cast.charAt(2); 
	char d = cast.charAt(3);

System.out.printf("%n%c %c %c %c", a, b, c, d);
	
	int num1 = Integer.parseInt(String.valueOf(a));
	int num2 = Integer.parseInt(String.valueOf(b));
	int num3 = Integer.parseInt(String.valueOf(c));
	int num4 = Integer.parseInt(String.valueOf(d));	
		
	num1 = (num1 + 7) % 10;
	num2 = (num2  + 7) % 10;
	num3 = (num3 + 7) % 10;
	num4 = (num4 + 7) % 10;
	
	String append = num3 + "" + num4 + "" + num1 + "" + num2;
		
	System.out.printf("%nThe encrypted value of %s is %s", cast, append);
		

	
			

		


	}
}