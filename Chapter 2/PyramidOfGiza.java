import java.util.Scanner;
public class PyramidOfGiza {
	public static void main(String[] args) {

	int numberOfStones = 2300000;
        double averageWeight = 2.5;
	int numberOfYears = 20;
 
	double totalStoneSize = numberOfStones * averageWeight;
        double yearlyWeight = totalStoneSize / numberOfYears; 
	double hourlyWeight = yearlyWeight / (365 * 24); 
	double minuteWeight = hourlyWeight / 60; 

	System.out.printf("The estimated weight of the pyramid built each year is %.2f tonnes%n", yearlyWeight);
	System.out.printf("The estimated weight of the pyramid built each hour is %.2f tonnes%n", hourlyWeight);
	System.out.printf("The estimated weight of the pyramid built each minute is %.2f tonnes%n", minuteWeight);


	}
}

	
	

	
	