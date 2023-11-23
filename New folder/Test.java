import java.util.Scanner;
public class Test {
	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	
	int largest = 0;
	int counter = 1;

	while (counter <= 10){
		
		System.out.printf("enter number: ");
		int num = input.nextInt();
		
		if (num > largest ){
			largest = num;
		}
		counter += 1;
	}

	
	System.out.printf("%n%d is the largest number", largest);
	

	}
}