import java.util.Scanner;
public class TaxCalculator {
	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	
	int counter = 3;
	
	while (counter >= 1){
		System.out.printf("Enter citizen's name: ");
		String name = input.next();	
		
		System.out.printf("Enter citizen's earning: ");
		double earning = input.nextDouble();

		if (earning > 0 && earning <= 30000){
			earning *= 0.15;		
			System.out.printf("%nTotal tax for citizen %s: $%.1f%n%n", name, earning);
		}
		
		if (earning > 30000){
			earning *= 0.20;			
			System.out.printf("%nTotal tax for citizen %s: $%.1f%n%n", name, earning);
		}
		
		counter--;
	
	
	}


	}
}
