import java.util.Scanner;
public class DivisibleBy5 {
	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	
	System.out.println("enter a number");
	int num = input.nextInt();
	
	if (num % 5 == 0 && num % 6 == 0)
		System.out.printf("is %d divisible by 5 and 6? true%n", num);
	else 
		System.out.printf("is %d divisible by 5 and 6? false%n", num);
	
	if (num % 5 == 0 || num % 6 == 0)
		System.out.printf("is %d divisible by 5 or 6? true%n", num);

	else 
		System.out.printf("is %d divisible by 5 or 6? false%n", num);

	if (num % 5 != 0 && num % 6 == 0 || num % 5 == 0 && num % 6 != 0)
		System.out.printf("is %d divisible by 5 or 6, but not both? true%n", num);
	else 
		System.out.printf("is %d divisible by 5 or 6, but not both? false%n", num);
	
	
	
       

	}
}