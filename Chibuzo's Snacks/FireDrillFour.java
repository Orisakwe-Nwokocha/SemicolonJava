import java.util.ArrayList;
import java.util.Scanner;

public class FireDrillFour {
    public static void main(String[] args) {

        ArrayList<Integer> numbers = populateArray();

        displayBarChart(numbers);
    }

    private static void displayBarChart(ArrayList<Integer> numbers) {
        for (int number : numbers) printAsterisksWith(number);
    }

    private static void printAsterisksWith(int number) {
        for (int count = 0; count < number; count++) System.out.print("*");
        System.out.println();
    }

    private static ArrayList<Integer> populateArray() {
        Scanner input = new Scanner(System.in);
        
        ArrayList<Integer> numbers = new ArrayList<>();

        while (true) {
            System.out.println("Enter a number between 1 and 15 (enter 22 to stop input): ");
            int number = input.nextInt();

            if (number == 22) break;

            if (number < 1 || number > 15) continue;

            numbers.add(number);
        }
        return numbers;
    }
}
