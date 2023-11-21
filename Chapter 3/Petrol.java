import java.util.Scanner;

public class Petrol {
	public static void main(String[] args) {
		
	PetrolPurchase buyPetrol = new PetrolPurchase("Yaba", "gasoline", 50, 600.00, 10.00);

	Scanner input = new Scanner(System.in);
	System.out.print("Welcome. Please enter your name: ");
	String name = input.nextLine();

	System.out.printf("%nHi, %s. You are purchasing %d litres of %s at #%.2f with a %.2f percent discount at ABC fuel station in %s%n", name, buyPetrol.getQuantity(), buyPetrol.getPetrolType(), buyPetrol.getPrice(), buyPetrol.getPercentageDiscount(), buyPetrol.getLocation());

	
	System.out.printf("%nThe purchase price after discount: #%.2f%n%nThanks for using our app!!!%n", buyPetrol.getPurchaseAmount());
	

	}
}