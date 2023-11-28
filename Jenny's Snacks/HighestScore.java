import java.util.Scanner;

public class HighestScore {

	public static void main(String[] args) {

	Scanner input = new Scanner(System.in);

	System.out.print("Enter the number of students: ");
	int num = input.nextInt();

	String studentName;
	int studentScore;

	int largest = 0;
	String largestName = "";

	int counter = 1; 			

	while (counter <= num) {
		System.out.print("Enter student name: ");
		studentName = input.next();
		System.out.print("Enter student scores: ");
		studentScore = input.nextInt();

		if (studentScore > largest) { 
			largest = studentScore;
			largestName = studentName;
		}
		
		
		counter++;
	}
	

	System.out.printf("%nThe student with the highest score is %s, with a score of %d", largestName, largest);


   }

}