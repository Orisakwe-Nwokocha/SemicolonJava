import java.util.Scanner;

public class OddOrEven {

    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);

   
           System.out.println("Enter an integer: ");

                      
            int input = sc.nextInt();

                       
            if (input % 2 == 0) {
             System.out.println("This is an even number");
            } 
	
		else {
                System.out.println("This is an odd number");
          
  }
        }

      
}
