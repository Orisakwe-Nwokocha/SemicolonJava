import java.util.Scanner;

public class SumOfDigits {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a four digit number: ");
        int num = input.nextInt();
        while (num < 1000 || num > 9999) {
            System.out.print("Invalid input\nPlease enter a four digit number: ");
            num = input.nextInt();
        }

        System.out.println("The sum of digits of " + num + " is: " + sumOfDigits(num));

    }

    public static int sumOfDigits(int number) {
        int sum = 0;
        for (int i = 1; i <= 4; i++) {
            sum += number % 10;
            number /= 10;
        }

        return sum;
    }
}
