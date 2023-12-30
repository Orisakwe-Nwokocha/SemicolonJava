public class PerfectNumbers {
    public static void main(String[] args) {

        for (int num = 1; num <= 10000; num++) {
            if (isPerfect(num)) {
                int sum = 0;
                System.out.print("\nThe factors of " + num + " is ");

                for (int count = 1; count < num; count++) {
                    if (num % count == 0) {
                        sum += count;
                        System.out.print(count + " ");
                    }
                }
                System.out.println("\nThe sum of the factors is " + sum);
                System.out.println(num + " is a perfect number\n");
            }
            else {
                System.out.println(num + " is not a perfect number");
            }
        }

    }
    public static boolean isPerfect(int number) {
        int sum = 0;
        for (int loop = 1; loop < number; loop++) {
            if (number % loop == 0) {
                sum += loop;
            }
        }
        return sum == number;
    }
}
