package fireDrillTwo;

import java.util.Scanner;

public class TaskNine {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int sum = 0;

        for (int count = 0; count < 10; count++) {
            System.out.println("Enter score:");
            int score = input.nextInt();

            if (score >= 0 && score <= 100) sum += score;
        }

        System.out.println("\nSum of scores ====> " + sum);
    }
}
