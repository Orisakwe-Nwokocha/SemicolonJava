import java.util.Scanner;

public class Table {

	public static void main(String[] args) {
 	
	System.out.printf("number\tsquare\tcube%n");
 	int[] number = {0, 1, 2, 3, 4, 5, 6 ,7, 8, 9, 10};
	
	for (int i = 0; i < number.length; i++) {     
		int square = i * i;
		int cube = i * i * i;
 	
		
		System.out.printf("%d\t%d\t%d%n", i, square, cube);
	}
	
	
 	
 } 
}
