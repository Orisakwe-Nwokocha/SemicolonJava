import java.security.SecureRandom;
import java.util.Scanner;

public class ComputerAssistedInstruction {
    private static final SecureRandom randomNumbers = new SecureRandom();
    private static int firstNumber;
    private static int secondNumber;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("NOTE: Enter -1 at any point to end program\n");

        int multiplicationResult = getMultiplicationQuestion();
        int userAnswer = input.nextInt();

        while (userAnswer != -1) {

            while (userAnswer != multiplicationResult) {
                System.out.println("No. Please try again.");
                System.out.printf("%nHow much is %d times %d?%n", firstNumber, secondNumber);
                userAnswer = input.nextInt();
            }

            System.out.println("Very good!\n");

            multiplicationResult = getMultiplicationQuestion();
            userAnswer = input.nextInt();
        }
    }

    public static int getMultiplicationQuestion() {
        firstNumber = randomNumbers.nextInt(1, 10);
        secondNumber = randomNumbers.nextInt(1, 10);

        int result = firstNumber * secondNumber;

        System.out.printf("How much is %d times %d?%n", firstNumber, secondNumber);

        return result;
    }
}
