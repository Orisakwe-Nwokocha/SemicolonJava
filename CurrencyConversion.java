import java.util.Scanner;
public class CurrencyConversion {
	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	
	System.out.println("Enter 0 to convert from US dollars to Chinese RMB | Enter 1 to convert from Chinese RMB to US dollars");
	double num = input.nextDouble();
	
	
	if (num == 0) {
		System.out.println("Enter the exchange rate from dollars to Chinese RMB");
		double dollarExchangeRate = input.nextDouble();
		System.out.println("Enter dollar amount");
		double dollar = input.nextDouble();
		double dollarToYuan = dollar * dollarExchangeRate;
		System.out.printf("$%.1f is %.1f yuan", dollar, dollarToYuan);
	}

	if (num == 1) {
		System.out.println("Enter the exchange rate from Chinese RMB to dollars");
		double yuanExchangeRate = input.nextDouble();
		System.out.println("Enter yuan amount");
		double yuan = input.nextDouble();
		double yuanToDollars = yuan / yuanExchangeRate;
		System.out.printf("%.1f yuan is $%.2f yuan", yuan, yuanToDollars);
	}

	
      


	}
}