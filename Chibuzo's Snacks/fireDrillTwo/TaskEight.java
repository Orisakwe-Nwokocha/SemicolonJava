package fireDrillTwo;

import java.util.Scanner;

public class TaskEight {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int sum = 0;

        for (int count = 0; count < 10; count++) {
            System.out.println("Enter score:");
            int score = input.nextInt();

            while (score < 0 || score > 100) {
                System.out.println("Invalid score\nPlease enter correct score:");
                score = input.nextInt();
            }

            sum += score;
        }

        System.out.println("Sum of scores ====> " + sum);
    }
}
