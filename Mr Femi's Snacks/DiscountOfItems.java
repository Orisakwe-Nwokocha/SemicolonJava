import java.util.Scanner;

public class DiscountOfItems {

	public static void main(String[] args) {

	Scanner input = new Scanner(System.in);

	System.out.print("Enter an item: ");
	String item = input.nextLine();

	System.out.printf("Enter %s's price: ", item);
	double price = input.nextDouble();

	while (price <= 0){
		System.out.printf("Invalid amount. Enter %s's price: ", item);
		price = input.nextDouble();
	}

	double discount = 10;
	double total = price - (price * (discount/100.0));

	System.out.printf("%nItem: %s%nPrice: %.2f%nDiscount: %.0f%s%nGrand total: %.1f", item, price, discount, "%", total);
	

   }

}