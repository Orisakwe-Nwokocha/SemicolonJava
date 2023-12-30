import java.security.SecureRandom;
import java.util.Scanner;

public class CAIVaryingTheTypesOfProblems {
    private static final SecureRandom randomNumbers = new SecureRandom();

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("NOTE: Type <Ctrl> d or <Ctrl> c then press Enter to end program\n");

        int arithmeticProblem;
        String difficultyLevel;
        int passPercentage;

        while (true) {
            passPercentage = 0;

            System.out.println("Choose arithmetic problem:");
            arithmeticProblem = input.nextInt();
            System.out.println("Choose a difficulty level:");
            difficultyLevel = input.next();

            for (int count = 1; count <= 10; count++) {
                System.out.printf("%nQuestion %d:%n", count);

                int arithmeticResult = getArithmeticQuestion(arithmeticProblem, difficultyLevel);
                int userAnswer = input.nextInt();

                System.out.println("The arithmetic result is " + arithmeticResult);

                if (userAnswer != arithmeticResult) {
                    System.out.println(getChatterForWrongAnswer());
                } else {
                    System.out.println(getChatterForCorrectAnswer());
                    passPercentage++;
                }

            }

            if (passPercentage < 8) {
                System.out.println("\nPlease ask your teacher for extra help\n");
            } else {
                System.out.println("\nCongratulations, you are ready to go to the next level!\n");
            }

        }

    }

    public static int getArithmeticQuestion(int arithmeticProblem, String difficultyLevel) {
        int firstNumber;
        int secondNumber;

        switch (difficultyLevel) {
            case "2":
                firstNumber = randomNumbers.nextInt(1, 100);
                secondNumber = randomNumbers.nextInt(1, 100);
                break;
            case "3":
                firstNumber = randomNumbers.nextInt(1, 1000);
                secondNumber = randomNumbers.nextInt(1, 1000);
                break;
            default:
                firstNumber = randomNumbers.nextInt(1, 10);
                secondNumber = randomNumbers.nextInt(1, 10);
        }

        int result = 0;

        switch (arithmeticProblem) {
            case 1:
                System.out.printf("How much is %d plus %d?%n", firstNumber, secondNumber);
                result = firstNumber + secondNumber;
                break;
            case 2:
                System.out.printf("How much is %d minus %d?%n", firstNumber, secondNumber);
                result = firstNumber - secondNumber;
                break;
            case 3:
                System.out.printf("How much is %d times %d?%n", firstNumber, secondNumber);
                result = firstNumber * secondNumber;
                break;
            case 4:
                System.out.printf("How much is %d divided by %d?%n", firstNumber, secondNumber);
                result = firstNumber / secondNumber;
                break;
            default:
                int randomProblem = randomNumbers.nextInt(1, 5);
                return getArithmeticQuestion(randomProblem, difficultyLevel);
        }

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
