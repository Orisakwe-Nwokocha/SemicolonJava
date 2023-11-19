import java.util.Scanner;

public class DayOfTheWeek {

	public static void main(String[] args){

	Scanner input = new Scanner(System.in);

	System.out.println("Enter year: (e.g., 2012): ");
	int year = input.nextInt();

	System.out.println("Enter month: 1-12: ");
	int month = input.nextInt();

	System.out.println("Enter the day of the month: 1-31: ");
	int day = input.nextInt();
	
	if (month == 1) {
		month = 13;
		year--;
	}

	if (month == 2) {
		month = 14;
		year--;
	}

        int h = (day + ((26* (month + 1)) / 10) + year + (year / 4) - (year / 100) + (year / 400)) % 7;

		

	if (h == 0) 
		System.out.printf("Day of the week is Saturday");
	
	if (h == 1) 
		System.out.printf("Day of the week is Sunday");

	if (h == 2) 
		System.out.printf("Day of the week is Monday");

	if (h == 3) 
		System.out.printf("Day of the week is Tuesday");
	
	if (h == 4) 
		System.out.printf("Day of the week is Wednesday");

	if (h == 5) 
		System.out.printf("Day of the week is Thursday");

	if (h == 6) 
		System.out.printf("Day of the week is Friday");

}

}