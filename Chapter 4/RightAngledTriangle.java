import java.util.Scanner;

public class RightAngledTriangle {
	public static void main(String[] args) {

 	Scanner input = new Scanner(System.in);
	System.out.print("Enter base of triangle: ");
	int base = input.nextInt();
	
	
	
	for (int i = 0; i <= base; i++) { 
 	  		for (int j = 0; j < i; ++j) {
    			System.out.print ("*"); 
  		}	
		System.out.println ();
	}	
		
		
		
		
		
	} 
 } 