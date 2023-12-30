import java.security.SecureRandom;
import java.util.Scanner;

public class CAIReducingStudentFatigue {
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
                System.out.println(getChatterForWrongAnswer());
                System.out.printf("%nHow much is %d times %d?%n", firstNumber, secondNumber);
                userAnswer = input.nextInt();
            }

            System.out.println(getChatterForCorrectAnswer() + "\n");

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

    public static String getChatterForCorrectAnswer() {
        int chatterNumber = randomNumbers.nextInt(1, 5);
        String chatterCorrectAnswer = null;

        switch (chatterNumber) {
            case 1 -> chatterCorrectAnswer = "Very good!";
            case 2 -> chatterCorrectAnswer = "Excellent!";
            case 3 -> chatterCorrectAnswer = "Nice work!";
            case 4 -> chatterCorrectAnswer = "Keep up the good work!";
        }

        return chatterCorrectAnswer;
    }

    public static String getChatterForWrongAnswer() {
        int chatterNumber = randomNumbers.nextInt(1, 5);
        String chatterWrongAnswer = null;

        switch (chatterNumber) {
            case 1 -> chatterWrongAnswer = "No. Please try again.";
            case 2 -> chatterWrongAnswer = "Wrong. Try once more.";
            case 3 -> chatterWrongAnswer = "Don't give up!!";
            case 4 -> chatterWrongAnswer = "No. Keep trying.";
        }

        return chatterWrongAnswer;
    }

}
