import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your weight in kilograms: ");
        int weight = input.nextInt();

        System.out.print("Enter your height in meters: ");
        double height = input.nextDouble();

        double bmi = weight / (height * height);

	if (bmi < 18.5)
        	System.out.printf("Your BMI is %.1f, indicating Underweight!!!%n", bmi);
	if (bmi >= 18.5 && bmi < 25)
        	System.out.printf("Your BMI is %.1f, indicating Normal weight!!!%n", bmi);
	if (bmi >= 25 && bmi < 30)
        	System.out.printf("Your BMI is %.1f, indicating Overweight!!!%n", bmi);
	if (bmi >= 30)
        	System.out.printf("Your BMI is %.1f, indicating Obesity!!!%n", bmi);

    }
}