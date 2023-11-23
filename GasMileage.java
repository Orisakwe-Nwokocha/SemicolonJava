import java.util.Scanner;
public class GasMileage {
	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);

	int totalMiles = 0;
	int totalGallons = 0;
	int totalTrips = 0;
	
	System.out.printf("%nEnter miles driven or enter -1 to quit: ");
	int miles = input.nextInt();

	while (miles != -1) {
		System.out.printf("Enter gallons used: ");
		int gallons = input.nextInt();
		
		double mpg = (double) miles / gallons;
		System.out.printf("The miles per gallon for this trip: %.2fMPG%n%n", mpg);
	
		System.out.printf("Enter miles driven or enter -1 to quit: ");
		miles = input.nextInt();
		
		totalMiles += miles;
		totalGallons += gallons;
		totalTrips++;

	}
	
	double combinedMpg = (double) totalMiles / totalGallons;
	System.out.printf("%n%nThe total miles driven for %d trips: %d miles%nThe total gallons used for %d trips: %d gallons%n", totalTrips, totalMiles, totalTrips, totalGallons);
	System.out.printf("%nThe combined miles per gallon obtained for %d trips: %.2fMPG%n", totalTrips, combinedMpg);

	}
}