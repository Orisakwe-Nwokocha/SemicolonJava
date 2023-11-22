import java.util.Scanner;
public class Car {
	private String model;
	private String year;	
	private double price;
	
Scanner input = new Scanner(System.in);

	public Car(String model, String year, double price) {
		this.model = model;
		this.year = year;
		if (price < 0.0) {
			System.out.printf("Enter the price of the car: %n");
			price = input.nextDouble();
			this.price = price;
			}
		else {
			this.price = price;
		}			
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public String getModel() {
		return model;
	}

	public void setYear(String year) {
		this.year = year;
	}
	
	public String getYear() {
		return year;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getPrice() {
		return price;
	}


 	
}