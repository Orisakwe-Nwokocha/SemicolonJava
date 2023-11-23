import java.util.Scanner;
public class LargestNumber {
	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
		
	int largest = 0;
	int counter = 1;
	int num = 0;

	while (counter <= 10){
		
		System.out.printf("enter number: ");
		num = input.nextInt();
		
		if (num > largest ){
			largest = num;
		}
		counter += 1;
	
	}
	
	System.out.printf("%n%nMost recent number: %d", num);

	System.out.printf("%nThe largest number: %d", largest);


	}
}
