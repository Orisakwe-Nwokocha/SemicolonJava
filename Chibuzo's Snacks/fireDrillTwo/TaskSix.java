package fireDrillTwo;

import java.util.Scanner;

public class TaskSix {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int sum = 0;
        int counter = 0;

        for (int count = 0; count < 10; count++) {
            System.out.println("Enter score:");
            int score = input.nextInt();


            if (score % 2 == 0) {
                sum += score;
                counter++;
            }
        }

        System.out.printf("Average of scores ====> %.2f", ((double) sum / counter));
    }
}
