import java.util.Scanner;

public class AbsoluteValue {

	public static void main(String[] args) {

	Scanner input = new Scanner(System.in);

	System.out.print("Enter an integer: ");
	int num = input.nextInt();
	int result = 1;
	
	if (num == 0){
		result = 0;
	}

	if (num < 0){
		result = num * -1;
	}

	if (num > 0){
		result = num * 1;
	}

	System.out.printf("%nThe absolute value of %d is %d", num, result);


   }

}