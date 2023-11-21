import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
 	Scanner input = new Scanner(System.in);
	System.out.println("Enter an Integer");

 	int fac = input.nextInt();
	int factorialize = 1;
	int i;

	if (fac < 2) System.out.println("1");
	
	else {
	for (i = 2; i <= fac; i++) { 
	factorialize = factorialize * 1;
 System.out.println(factorialize);
	}
	}


 
 	
 } 
}
