public class PrintStars {
    public static void main(String[] args) {

        final int MAX_ROWS = 10;
        for (int counter = 1; counter <= MAX_ROWS; counter++) {
            printStars(counter);
            printSpaces(14  - counter);
            printStars(11 - counter);
            printSpaces((counter + 1) * 2);
            printStars(11 - counter);
            printSpaces(14 - counter);
            printStars(counter);
            System.out.println();
        }

    }

    private static void printSpaces(int number) {
        for (int row = 1; row <= number; row++) {
            System.out.print(" ");
        }
    }

    private static void printStars(int number) {
        for (int row = 1; row <= number; row++) {
            System.out.print("*");
        }
    }
}
