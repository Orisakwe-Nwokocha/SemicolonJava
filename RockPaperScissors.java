import java.util.Scanner;
public class RockPaperScissors {
	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	
	System.out.print("Enter player one name: ");
	String player1 = input.nextLine();
	System.out.print("Enter player two name: ");
	String player2 = input.nextLine();

	System.out.printf("%s enter a number 0, 1, or 2:%n", player1);
	int num1 = input.nextInt();
	System.out.printf("%s enter a number 0, 1, or 2:%n", player2);
	int num2 = input.nextInt();

	if (num1 == 0 && num2 == 1) 
		System.out.printf("%s won %s!!!%n", player2, player1);

	if (num1 == 0 && num2 == 2) 
		System.out.printf("%s won %s!!!%n", player1, player2);

	if (num1 == 0 && num2 == 0) 
		System.out.println("The match is a draw!!!");
	
	if (num1 == 1 && num2 == 1) 
		System.out.println("The match is a draw!!!");

	if (num1 == 1 && num2 == 0) 
		System.out.printf("%s won %s!!!%n", player1, player2);

	if (num1 == 1 && num2 == 2) 
		System.out.printf("%s won %s!!!%n", player2, player1);

	if (num1 == 2 && num2 == 1) 
		System.out.printf("%s won %s!!!%n", player1, player2);

	if (num1 == 2 && num2 == 0) 
		System.out.printf("%s won %s!!!%n", player2, player1);

	if (num1 == 2 && num2 == 2) 
		System.out.println("The match is a draw!!!");   

	}
	public static void main(String[] args) {
		
	System.out.print("Enter player one name: ");
	}
}