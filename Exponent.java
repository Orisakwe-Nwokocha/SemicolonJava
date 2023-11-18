import java.util.Scanner;
public class Exponent {
	public static void main(String[] args) {

	Scanner userInput = new Scanner(System.in);
	
	System.out.println("Enter base number");
	double base = userInput.nextDouble();
	
	System.out.println("Enter power number");
	double power = userInput.nextDouble();
	double manipulator = 1;

	if (power == 0) {
       	System.out.println("1");
    	}
	
	if (power > 0) {
		for (int i = 0; i < power; i++) {
			manipulator = manipulator * base;
		}
	}
	
		else {
		for (int i = 0; i > power; i--) {
			manipulator = manipulator * base;
		}
	}
	
	if (power > 0) {
		System.out.println(base + " raised to power " + power + " = " + manipulator);
	}

	if (power < 0) {
		manipulator = 1 / manipulator;
		System.out.println(base + " raised to power " + power + " = " + manipulator);
	}
	

}

}