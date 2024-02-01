package fireDrillTwo;

import java.util.Scanner;

public class TaskFour {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int sum = 0;
        int counter = 0;

        for (int count = 0; count < 10; count++) {
            System.out.println("Enter score:");
            int score = input.nextInt();

            if (count % 2 == 0) {
                sum += score;
                counter++;
            }
        }

        System.out.println("Sum of scores at even indexes ====> " + sum);
    }
}
