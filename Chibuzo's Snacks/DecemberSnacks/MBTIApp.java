import java.util.Scanner;

public class MBTIApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("What is your name:");
        String name = input.nextLine();

        MBTI.displayQuestions();

        System.out.printf("Hello %s, you selected%n", name);

        MBTI.getMBTI();

    }

}
