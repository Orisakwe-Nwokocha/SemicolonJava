import java.util.Scanner;

public class HeartRateApp {
	public static void main(String[] args) {
		
	HeartRates monitor = new HeartRates();

	Scanner input = new Scanner(System.in);
	
	System.out.printf("Enter your first name: ");
	String userFirstName = input.nextLine();
	monitor.setFirstName(userFirstName);

	System.out.printf("Enter your last name: ");
	String userLastName = input.nextLine();
	monitor.setLastName(userLastName);

	System.out.printf("Enter your month of birth: ");
	int userDobMonth = input.nextInt();
	monitor.setDobMonth(userDobMonth);

	System.out.printf("Enter your day of birth: ");
	int userDobDay = input.nextInt();
	monitor.setDobDay(userDobDay);

	System.out.printf("Enter your year of birth: ");
	int userDobYear = input.nextInt();
	monitor.setDobYear(userDobYear);

	System.out.printf("%nInformation of user:%nName: %s %s%nD.O.B: %d/%d/%d%nAge: %d years%n", monitor.getFirstName(), monitor.getLastName(), monitor.getDobMonth(), monitor.getDobDay(), monitor.getDobYear(), monitor.getAge());

	System.out.printf("%nFor user of %d years, your health details are:%n%nMaximum heart rate is: %d beats per minute%nLow target heart rate is: %.1f beats per minute%nHigh target heart rate is: %.1f beats per minute%n", monitor.getAge(), monitor.getMaxHeartRate(), monitor.getLowHeartRate(), monitor.getHighHeartRate());


	

	}
}