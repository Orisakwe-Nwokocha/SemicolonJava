import java.util.Scanner;
public class DistanceOfPoints {
	public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in);

	System.out.println("Enter the x coordinate of the first point: ");
	double x1 = sc.nextDouble();
	
	System.out.println("Enter the y coordinate of the first point: ");
	double y1 = sc.nextDouble();

	System.out.println("Enter the x coordinate of the second point: ");
	double x2 = sc.nextDouble();

	System.out.println("Enter the y coordinate of the second point: ");
	double y2 = sc.nextDouble();

	if (x1 == x2) {
    		System.out.println("The points are on a line perpendicular to the x-axis.");
	}
	
	else if (y1 == y2) {
    		System.out.println("The points are on a line perpendicular to the y-axis.");
    	}
	
	else {
   		 System.out.println("The points are not on a line perpendicular to any axis.");
	}


	}
}