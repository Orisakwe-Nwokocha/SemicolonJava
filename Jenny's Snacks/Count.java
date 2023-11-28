import java.util.Scanner;

public class Count {

	public static void main(String[] args) {

	Scanner input = new Scanner(System.in);

	System.out.print("Enter an integer, the input ends if it is 0: ");
	int num = input.nextInt();
	int posCount = 0;
	int negCount = 0;
	int positive = 0;
	int negative = 0; 			

	while (num != 0) {
		if (num > 0) { 
			positive += num;
			posCount++;
		}
		
		if (num < 0) { 
			negative += num;
			negCount++;
		}
		
		System.out.print("Enter an integer, the input ends if it is 0: ");
		num = input.nextInt();
	}
	
	double total = positive + negative;
	double average =  total / (posCount + negCount);

	System.out.printf("%nThe number of positives is %d", posCount);
	System.out.printf("%nThe number of negatives is %d", negCount);
	System.out.printf("%nThe total is %.1f", total);
	System.out.printf("%nThe average is %.2f", average);


   }

}