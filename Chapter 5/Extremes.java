import java.util.Scanner;

public class Extremes {

	public static void main(String[] args) {

	Scanner input = new Scanner(System.in);

	System.out.print("Enter the number of values you want to input: ");
	int prompt = input.nextInt();
	
	int counter = 1;
	System.out.printf("Enter number %d: ", counter);
	int num = input.nextInt();	
	int maximum = num;
	int minimum = num;

	while (counter < prompt){

		if (num < minimum){
			minimum  = num;			
		}
	
		if (num > maximum){
			maximum = num;
		}

		counter++;
		System.out.printf("Enter number %d: ", counter);
		num = input.nextInt();
	}
	
	int sum = maximum + minimum;

	System.out.printf("%nThe minimum value: %d", minimum);
	System.out.printf("%nThe maximum value: %d", maximum);
	System.out.printf("%nThe sum of %d and %d: %d", minimum, maximum, sum);
   }

}