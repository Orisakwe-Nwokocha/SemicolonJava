import java.util.Scanner;
public class ValidatingUserInput {
	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	
	int pass = 0;
	int fail = 0;
	int counter = 1;
	int result = 0;
	while (counter <= 10) {		
		System.out.printf("Enter result (1 = pass, 2 = fail): ");
		 result = input.nextInt();		
		
		if (result == 1){
			pass++;
			counter = counter + 1;
		} 
		
		if (result == 2){
			fail++;
			counter = counter + 1;
		}
		
		else if (result != 1 && result != 2){
			System.out.printf("Invalid input. Enter either 1 for pass || 2 for fail%n%n");
		}
			
			

	} 
	
	System.out.printf("%nThe number of students who passed: %d%nThe number of students who failed: %d%n%n", pass, fail);

	if (pass > 8){
		System.out.println("Bonus to instructor!");
		
		}
	


	}
}