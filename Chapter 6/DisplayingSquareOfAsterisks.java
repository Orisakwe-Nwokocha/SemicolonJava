import java.util.Scanner;

public class DisplayingSquareOfAsterisks {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter side of asterisks: ");
        int num = input.nextInt();

        squareOfAsterisks(num);
    }
    public static void squareOfAsterisks(int side) {
        for (int loop = 1; loop <= side; loop++) {
            for (int loop2 = 1; loop2 <= side; loop2++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
