import java.util.Scanner;

public class PerfectNumbers {
    public static void main(String[] args) {
        int num = 6;

        for (int loop = 1; loop <= 10000; loop++) {
            isPerfect(loop);
        }

    }
    public static boolean isPerfect(int number) {
        int sum = 0;
        for (int loop = 1; loop < number; loop++) {
            if (number % loop == 0) {
                sum += loop;
            }
        }
        if (sum == number) {
            System.out.print("The factors of " + number + " is ");
            for (int loop = 1; loop < number; loop++) {
                if (number % loop == 0) {
                    System.out.print(loop + " ");
                }
            }
            System.out.println();
            System.out.println(number + " is a perfect number");
            return true;
        } else {
            System.out.println(number + " is not a perfect number");
            return false;
        }
    }
}
