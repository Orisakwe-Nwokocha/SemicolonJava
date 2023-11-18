import java.util.Scanner;

public class SumOfEvenAndOdd {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int evenSum = 0;
        int oddSum = 0;

       
        System.out.println("Enter a set of integers [enter 0 to end]:");

       
        while (true) {
     
            int num = sc.nextInt();

           
            if (num == 0) {
                break;
            }

            
            if (num % 2 == 0) {
                evenSum += num;
            } 
		
	    else {
                oddSum += num;
            }
        }

     

      
        System.out.println("The sum of even integers is " + evenSum);
        System.out.println("The sum of odd integers is " + oddSum);
    }
}
