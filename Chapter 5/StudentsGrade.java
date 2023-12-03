import java.util.Scanner;

public class StudentsGrade {
	public static void main(String... args){

	Scanner input = new Scanner(System.in);

	int aCount = 0;
	int bCount = 0;
	int cCount = 0;
	int dCount = 0;
	int counter = 1;

	while (counter <= 5) {
		System.out.printf("Enter student %d name: ", counter);
		String studentName = input.next();
		System.out.printf("Enter student %d grade: ", counter);
		String studentGrade = input.next();

		switch (studentGrade) {
			case "A":
				aCount++;
				break;

			case "B":
				bCount++;
				break;

			case "C":
				cCount++;
				break;

			case "D":
				dCount++;
				break;	
		}
		
		counter++;
	}

	
	System.out.printf("%nNumber of students who received each grade: %nA: %d%nB: %d%nC: %d%nD: %d%n", aCount, bCount, cCount, dCount);	


	}

}