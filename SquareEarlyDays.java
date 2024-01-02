public class SquareEarlyDays {
    public static void main(String[] args) {

        int base = 3;
        int result = 1;
        for (int loop = 1; loop <= 4; loop++) {
            result *= base;
        }
        System.out.println(result);

        int count = 0;

        for (int number = 0; number <= 100; number++) {
            if (isSquareNumber(number)) {
                count++;
                System.out.printf("%d:  %d is a square number%n", count, number);
            }
        }
        System.out.printf("\nThere are %d perfect squares between 0-100 (both inclusive)", count);

    }
    public static boolean isSquareNumber(int num) {
        if (num == 0) return true;
        for (int loop = 1; loop <= num; loop++) {
            if (num / loop == loop && num % loop == 0) {
                return true;
            }
        }
        return false;
    }
}
