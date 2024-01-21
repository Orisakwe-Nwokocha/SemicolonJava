import java.util.Scanner;

public class MBTIPersonalityTestApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("What is your name:");
        String name = input.nextLine();

        MBTIPersonalityTest.displayQuestions();

        System.out.printf("Hello %s, you selected%n", name);

        MBTIPersonalityTest.getMBTI();

    }

}
