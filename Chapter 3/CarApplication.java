public class CarApplication {
	public static void main(String[] args) {
		
	Car volkswagen  = new Car("Beetle", "1960", 40000);
	Car honda = new Car("Civic", "2009", -7000);
	
	String model1 = volkswagen.getModel();
	String model2 = honda.getModel();
	double price1 = volkswagen.getPrice();
	double price2 = honda.getPrice();

	System.out.printf("%nThe prices are shown as below:%n%s = $%.2f%n%s = $%.2f%n", model1, price1, model2, price2);
	
	double discountedPrice1 = price1 - (price1 * 0.05);
	double discountedPrice2 = price2 - (price2 * 0.07);

	System.out.printf("%nThe prices after discount are shown as below:%n%s = $%.2f%n%s = $%.2f%n", model1, discountedPrice1, model2, discountedPrice2);
	


	}
}