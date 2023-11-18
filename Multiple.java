import java.util.Scanner;

public class Multiple {
	
	public static void main(String[] args) {
 	
		Scanner input = new Scanner(System.in);
 	
	System.out.println("Enter number to be tripled"); 

	float triple = input.nextFloat();

	
	System.out.println("Enter number to be doubled"); 

	float doub = input.nextFloat();

	
	float tripled = triple * 3;
	float doubled = doub * 2;


	if (tripled % doubled == 0) {
	
	System.out.printf("%.1f  is a multiple of %.1f%n", triple, doub); 
	}

	else {
	
	System.out.printf("%.1f  is not a multiple of %.1f%n", triple, doub); 
	}

}
}