import java.util.Scanner;

public class PalindromeNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter integer: ");
        int num = input.nextInt();

        while (num < 10) {
            System.out.println("Invalid input");
            System.out.print("Enter integer greater than 9: ");
            num = input.nextInt();
        }

        if (isPalindrome(num)) {
            System.out.println(num + " is a palindrome");
        } else {
            System.out.println(num + " is not a palindrome");
        }

    }
    public static boolean isPalindrome(int palindrome) {
        String palindromeNumber = palindrome + "";
        StringBuilder reverseStr = new StringBuilder(palindromeNumber);
        String reversedStr = reverseStr.reverse().toString();

        if (palindromeNumber.equals(reversedStr)) {
            return true;
        } else {
            return false;
        }
    }
}
