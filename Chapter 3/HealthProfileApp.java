import java.util.Scanner;

public class HealthProfileApp {
	public static void main(String[] args) {
		
	HealthProfile monitor = new HealthProfile();

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

	System.out.printf("Enter your year weight in pounds: ");
	double userWeight = input.nextDouble();
	monitor.setWeight(userWeight);

	System.out.printf("Enter your height in inches: ");
	double userHeight = input.nextDouble();
	monitor.setHeight(userHeight);


	System.out.printf("%nInformation of user:%n%nName: %s %s%nD.O.B: %d/%d/%d%nAge: %d years%nHeight: %.1f%nWeight: %.1f%n", monitor.getFirstName(), monitor.getLastName(), monitor.getDobMonth(), monitor.getDobDay(), monitor.getDobYear(), monitor.getAge(), monitor.getHeight(), monitor.getWeight());

	monitor.targetHeartRate();
	monitor.bmi();

	

	}
}