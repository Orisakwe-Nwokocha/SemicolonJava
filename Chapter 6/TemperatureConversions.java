import java.util.Scanner;

public class TemperatureConversions {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter K to convert from celsius to kelvin || Enter C to convert from kelvin to celsius: ");
        String choice = input.nextLine();
        
        while (choice.compareToIgnoreCase("k") != 0 && choice.compareToIgnoreCase("c") != 0) {
            System.out.println("Invalid input");
            System.out.print("Enter K to convert from celsius to kelvin || Enter C to convert from kelvin to celsius: ");
            choice = input.nextLine();
        }

        if (choice.equalsIgnoreCase("k")) {
            System.out.print("Enter celsius temperature: ");
            double celsius = input.nextDouble();
            double kelvin = kelvin(celsius);
            System.out.printf("%n%.2f°C to kelvin is %.2fK%n", celsius, kelvin);

        } else if (choice.equalsIgnoreCase("c")) {
            System.out.print("Enter kelvin temperature: ");
            double kelvin = input.nextDouble();
            double celsius = celsius(kelvin);
            System.out.printf("%n%.2fK to celsius is %.2f°C%n", kelvin, celsius);
        }

    }
    public static double kelvin(double celsius) {
        double celsiusToKelvin = celsius + 273.15;
        return celsiusToKelvin;
    }
    public static double celsius(double kelvin) {
        double kelvinToCelsius = kelvin - 273.15;
        return kelvinToCelsius;
    }
}
