import java.util.Scanner;
public class ResultsCounting {
	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	
	int pass = 0;
	int fail = 0;
	int counter = 1;

	while (counter <= 10){		
		System.out.print("Enter result: ");
		int result = input.nextInt();		
		
		if (result == 1){
			pass++;
		} 
		
		if (result == 2){
			fail++;
		}
			
		counter = counter + 1;	

	} 
	
	System.out.printf("%nThe number of students who passed: %d%nThe number of students who failed: %d%n%n", pass, fail);

	if (pass > 8){
		System.out.println("Bonus to instructor!");
		
		}
	


	}
}