import java.util.Scanner;
public class TwoLargestNumber {
	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	
	int secondLargest = 0;	
	int largest = 0;
	
	int counter = 1;
	int num;

	while (counter <= 10){
		
		System.out.printf("enter number %d: ", counter);
		num = input.nextInt();
		
		if (num > largest){
			secondLargest = largest;
			largest = num;
		}
		
		else if (num > secondLargest) {
			secondLargest = num;
		}

		counter ++;
	
	}
	
	System.out.printf("%nThe largest number: %d", largest);		
	System.out.printf("%nThe second largest number: %d", secondLargest);
	System.out.printf("%nMost recent number: %d", num);


	}
}
