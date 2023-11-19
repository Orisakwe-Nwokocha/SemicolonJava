import java.util.Scanner;

public class DayOfTheWeek {

	public static void main(String[] args){

	Scanner input = new Scanner(System.in);

	System.out.printf("Enter year: (e.g., 2012): %n");
	int year = input.nextInt();

	System.out.printf("Enter month: 1-12: %n");
	int month = input.nextInt();

	System.out.printf("Enter the day of the month: 1-31: %n");
	int day = input.nextInt();
	
	if (month == 1) {
		month = 13;
		year--;
	}

	if (month == 2) {
		month = 14;
		year--;
	}

        int q = day;
        int m = month;
	int k = year % 7;
        int j = year / 100; 
		
        int h = (q + ((26 * (m + 1)) / 10) + k +  (k / 4) + (j / 4) + (5 * j)) % 7;

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
