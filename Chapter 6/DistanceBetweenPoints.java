import java.util.Scanner;

public class DistanceBetweenPoints {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter distance for x1:");
        double a1 = input.nextDouble();
        System.out.println("Enter distance for x2:");
        double a2 = input.nextDouble();
        System.out.println("Enter distance for y1:");
        double b1 = input.nextDouble();
        System.out.println("Enter distance for y2:");;
        double b2 = input.nextDouble();


        double distance = calculateDistance(a1, a2, b1, b2);

        System.out.println("Distance between the points: " + distance);
    }

    public static double calculateDistance(double x1, double x2, double y1, double y2) {
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }
}

