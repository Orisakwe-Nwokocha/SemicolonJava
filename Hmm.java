import java.util.Scanner;
public class Hmm {
	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	
 	System.out.println("Enter a String");
	String received = input.nextLine();
	
	String conversion = received.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
	StringBuilder reverseString = new StringBuilder(conversion);
	reverseString.reverse();
	
	String reversed = reverseString.toString();
		
	System.out.println(conversion);
	System.out.println(reversed);
	if (conversion.equals(reversed))
		System.out.println("true");

	else 		
		System.out.println("false");
	 
	

	}
}