import java.util.ArrayList;
import java.util.Arrays;

public class LongestWordInAString {
    public static String findLongestWordLength(String str) {
        ArrayList<String> splittedArray = new ArrayList<>();

        String s = "";
        for (int index = 0; index < str.length(); index++){
            if (str.charAt(index) == ' ') {
                splittedArray.add(s);
                s = "";
            }
            else {
                s += str.charAt(index);
            }
        }

        if (!s.isEmpty()) splittedArray.add(s);

        int longestWord = 0;
        String result = "";

        for (String word : splittedArray) {
            if (word.length() > longestWord) {
                longestWord = word.length();
                result = word + "";
            }
        }

        return String.format("""
                The longest word in the string... "%s" is:
                '%s'
                The length is:
                %d""", str, result, longestWord);
    }

    public static void main(String[] args) {
        System.out.println(findLongestWordLength("The quick brown fox jumped over the lazy dog"));
        System.out.println(findLongestWordLength("May the force be with you"));
        System.out.println(findLongestWordLength("Google do a barrel roll"));
        System.out.println(findLongestWordLength("What is the average airspeed velocity of an unladen swallow"));
        System.out.println(findLongestWordLength("What if we try a super-long word such as otorhinolaryngology"));

        String myString = "The quick brown fox jumped\t\t\tB. over the lazy dog";
        System.out.println();
        String[] splittedArray = myString.split("\t");
        System.out.println(splittedArray.length);
        System.out.println(Arrays.toString(splittedArray));

        System.out.println(splittedArray[splittedArray.length - 1]);

    }
}
