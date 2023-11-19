import java.util.Scanner;

public class PerimeterOfATriangle {

	public static void main(String[] args){

	Scanner input = new Scanner(System.in);

	System.out.println("Enter first edge:");
	int edge1 = input.nextInt();

	System.out.println("Enter second edge:");
	int edge2 = input.nextInt();

	System.out.println("Enter third edge:");
	int edge3 = input.nextInt();

	int perimeter;

	if (edge1 + edge2 > edge3 && edge1 + edge3 > edge2 && edge2 + edge3 > edge1) {
		perimeter = edge1 + edge2 + edge3;
		System.out.println("The perimeter of the triangle is " + perimeter);
	}

	else {
		System.out.println("Invalid input");
	}	

}

}