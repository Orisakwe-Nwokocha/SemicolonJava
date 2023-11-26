import java.util.Scanner;
public class Prime2 {
	public static void main(String[] args) {

	Scanner userInput = new Scanner(System.in);
	
	System.out.print("Enter a number: ");
	int num = userInput.nextInt();
	int i;
	boolean prime = true;
	int fail = 0;
	
		
		for (i = 2; i < num; i++) {
					
			if (num % i == 0) {
			//fail++;
				//System.out.print(num + " is not a prime number");
				//break;
				System.out.println(num + " can be divided by " + i + " without remainder");
				// prime = false;
				// break;
		}
	}
	System.out.println();
	/*	
	if (num <= 1) {
		System.out.print(num + " is not a prime number"); 
	}
		
	else if (fail > 0){
		System.out.println(num + " can be divided without remainder " + fail + " times - therefore:");
		System.out.print(num + " is not a prime number!!!");
	}
	
	else {
		System.out.println(num + " can be divided without remainder " + fail + " times - therefore:");
		System.out.print(num + " is a prime number!!!");
	}*/
		
	/*
	if (prime)
		System.out.println(num + " is  a prime number");
	else
		System.out.print(num + " is not a prime number"); */
		

}

}