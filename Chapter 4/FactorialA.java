import java.util.Scanner;

public class FactorialA {
	public static void main(String[] args){
	
	Scanner input =  new Scanner(System.in);
	
	System.out.print("Enter a number: ");
	int num = input.nextInt();
	int factorial = 1;
	int counter = 0;
	
	while (counter < num){
		counter++;
		factorial *= counter;
		
	}
	
	System.out.printf("%n%d factorial is %d", num, factorial);
	
	
	}
}