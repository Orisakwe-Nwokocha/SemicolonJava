import java.util.Scanner;

public class SumDigits {

	public static int sum_of_all_digits (int integers) {
 	
	
	if (integers <= 0) {
        	return 0;

    }
	if (integers > 999) {
         return 0;
	
	
    }
	return (integers % 10) + sum_of_all_digits (integers / 10);

	
	
 	
 } 

public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
	System.out.println("Enter integer "); 
	int digit = input.nextInt();
		System.out.println(sum_of_all_digits(digit));
   
}
}
