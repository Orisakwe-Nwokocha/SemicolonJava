import java.util.Scanner;

public class DisplayingSquareOfAnyCharacter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter side of asterisks: ");
        int num = input.nextInt();

        System.out.print("Enter character of asterisks: ");
        char fill = input.next().charAt(0);

        squareOfAsterisks(num, fill);
    }
    public static void squareOfAsterisks(int side, char fillCharacter) {
        for (int loop = 1; loop <= side; loop++) {
            for (int loop2 = 1; loop2 <= side; loop2++) {
                System.out.print(fillCharacter);
            }
            System.out.println();
        }
    }
}
