import java.util.Scanner;

public class Reverse {

	public static void main(String[] args) {
 	Scanner input = new Scanner(System.in);
	System.out.println("Enter a String");

 	String reverseString = input.nextLine();
	StringBuilder rS = new StringBuilder(reverseString);
	String output = rS.reverse().toString();
	System.out.println(output);

 
 	
 } 
}
