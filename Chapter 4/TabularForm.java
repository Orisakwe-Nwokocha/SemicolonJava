import java.util.Scanner;
public class TabularForm {
	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
		
	int counter = 1;
	int square, cube, quartic;
	System.out.printf("N\t\tN2\t\tN3\t\tN4%n");

	while (counter <= 5){
		square = counter * counter;
		cube = counter * counter * counter;
		quartic = counter * counter * counter * counter;

		System.out.printf("%n%d\t\t%d\t\t%d\t\t%d", counter, square, cube, quartic);
	
		counter ++;
	
	}
	


	}
}
