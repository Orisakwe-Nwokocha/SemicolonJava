import java.util.Scanner;
public class SalesCommission {
	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	
	int wage = 200;
	double item1 = 239.99;
	double item2 = 129.75;
	double item3 = 99.95;
	double item4 = 350.89;

	int item1Count = 0;
	int item2Count = 0;
	int item3Count = 0;
	int item4Count = 0;
	
	System.out.printf("Enter items id sold (1-4) || Input 0 to end: ");
	int num = input.nextInt();
	
	while (num >= 1 && num <=4){
	
		if (num == 1){
			item1Count++;
		}
		
		if (num == 2){
			item2Count++;
		}

		if (num == 3){
			item3Count++;
		}

		if (num == 4){
			item4Count++;
		}
		
		System.out.printf("Enter items id sold (1-4) || Input 0 to end: ");
		num = input.nextInt();
	
	}

	double result1 = item1Count * item1;
	double result2 = item2Count * item2;
	double result3 = item3Count * item3;
	double result4 = item4Count * item4;
	double resultTotal = result1 + result2 + result3 + result4;

	double fullWage = wage + (0.09 * resultTotal);

        System.out.printf("%n%nThe salesperson's commission for the week is $%.2f", fullWage);


	}
}
