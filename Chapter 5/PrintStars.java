public class PrintStars {
    public static void main(String[] args) {
        printTriangles();
        System.out.println();
        printDiamond();
    }

    private static void printTriangles() {
        for (int counter = 1; counter <= 10; counter++) {
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

    private static void printDiamond() {
        int stars = 1;
        int spaces = 4;

        for (int counter = 1; counter <= 9; counter++) {
            printSpaces(spaces);
            printStars(stars);
            System.out.println();

            stars = counter >= 5 ? stars - 2 : stars + 2;
            spaces = counter >= 5 ? spaces + 1: spaces - 1;
        }
    }

    private static void printSpaces(int number) {
        for (int row = 1; row <= number; row++) System.out.print(" ");
    }

    private static void printStars(int number) {
        for (int row = 1; row <= number; row++) System.out.print("*");
    }
}
