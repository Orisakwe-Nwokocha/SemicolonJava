import java.util.Scanner;

public class Factor {

    public static void main(String[] args) {
       
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter a number:");

       
        int num = input.nextInt();

	while (num <= 0) {
            System.out.println("Invalid input. Please enter a positive integer.");
            System.out.println("Enter a positive number:");
	    num = input.nextInt();
	
        }
	
       System.out.print("The factors of " + num + " are : ");   
	
	for (int i = 1; i <= num; i++) {	

		if (num % i == 0) {
         		System.out.print(i + " ");   
            	}     
           
	}

 	 
    }
}
