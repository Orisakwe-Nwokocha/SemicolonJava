import java.util.Scanner;

public class Years {

	public static void main(String[] args) {
 	
	Scanner input = new Scanner(System.in);
 	
	System.out.println("Enter minute(s): ");  
	long minutes = input.nextLong();
	
	int oneHour = 60;
	int oneDay = 24;
	int oneYear = 365;
	
	int totalMinutesInOneYear = oneYear * oneHour * oneDay;
	
	long noOfYears = minutes / totalMinutesInOneYear;
	long remainingDays = (minutes % totalMinutesInOneYear) / (oneHour * oneDay);
	long remainingHours = (minutes %  1440) / 60;
	
			
	System.out.printf("%,d minutes is approximately %,d year(s), %d day(s), and %d hours\t%d%n", minutes, noOfYears, remainingDays, remainingHours);

	
	
 	
 } 
}
