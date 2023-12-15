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
   public static boolean palindromeChecker(String[] string){
        string[0] = string[0].toLowerCase().replaceAll("[^a-zA-Z0-9]", "");

        String word = string[0];
        char[] charArray = new char[word.length()];
        int count = word.length() - 1;

        for (int index = 0; index < word.length(); index++){
            charArray[count] = word.charAt(index);
            count--;
        }

        String[] reversedString = new String[string.length];
        String reversedWord = new String(charArray);
        reversedString[0] = reversedWord;

        for (int index = 0; index < string.length; index++){
            if (string[index].equals(reversedString[index])){
                return true;
            }
        }

        return false;
    }
}
