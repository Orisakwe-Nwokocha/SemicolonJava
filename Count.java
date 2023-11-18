import java.util.Scanner;

public class Count {

    public static void main(String[] args) {
       
        Scanner userInput = new Scanner(System.in);
        int positiveCount = 0;
        int negativeCount = 0;
        int zeroCount = 0;
	int num, i;

	System.out.println("How many numbers (elements) do you want to enter?");
	num = userInput.nextInt();
 	
	int[] set = new int[num];
	
	for(i = 0; i < num; i++){
                System.out.println("Enter n element " + (i + 1) + ":");
             set[i] = userInput.nextInt();   
	}

	for (i = 0; i < set.length; i++) {
			
		if (set[i] == 0) {
	    		zeroCount++;  
		}     
      	
		else if (set[i] > 0) {
            		positiveCount++;
            	}
	
		else  {
  			negativeCount++;   
              	}


	}
	
      	System.out.println("Zero numbers: " + zeroCount); 
      	System.out.println("Positive numbers: " + positiveCount);
	System.out.println("Negative numbers: " + negativeCount);

    }
}