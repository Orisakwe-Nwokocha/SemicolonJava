import java.util.Scanner;

public class TestForLeapYear {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a year: ");
        int year = input.nextInt();

        if (isLeapYear(year)) {
            System.out.println(year + " is a leap year!!!!");
        } else {
            System.out.println(year + " is not a leap year!!!!");
        }
    }
    public static boolean isLeapYear(int leapYear) {
        if ((leapYear % 4 == 0) && (leapYear % 100 != 0 || leapYear % 400 == 0)) {
            return true;
        } else {
            return false;
        }
    }
}
