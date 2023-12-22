import java.util.Arrays;

public class PalindromeArray {

    public static void main(String[] args) {
        String[] stringToCheck = {"Hannah"};

        boolean isPalindrome = palindromeChecker(stringToCheck);

        if (isPalindrome){
            System.out.println(stringToCheck[0] + " is a palindrome");
        } else {
            System.out.println(stringToCheck[0] + " is not a palindrome");
        }

    }
   public static boolean palindromeChecker(String[] word){
       word[0] = word[0].toLowerCase().replaceAll("[^a-zA-Z0-9]", "");

        String text = word[0];
        char[] charArray = new char[text.length()];
        int count = text.length() - 1;

        for (int index = 0; index < text.length(); index++){
            charArray[count] = text.charAt(index);
            count--;
        }

        String reversedWord = new String(charArray);

        if (text.equals(reversedWord)) {
            return true;
        }
        else {
            return false;
        }
    }
}
