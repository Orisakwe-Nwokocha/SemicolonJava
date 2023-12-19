import java.util.Arrays;
import java.util.Scanner;

public class BeautifyingStrings {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String test = input.nextLine();

        beautifyString(test);

    }
    public static String addFullStop(String strFullStop) {
        if (strFullStop.endsWith(".")) {
            return strFullStop;
        } else {
            return strFullStop + ".";
        }
    }
    public static String capitaliseFirstLetter(String strTitleCase) {
        if (strTitleCase == null || strTitleCase.length() == 0 || Character.isUpperCase(strTitleCase.charAt(0))) {
            return strTitleCase;
        } else {
            return Character.toUpperCase(strTitleCase.charAt(0)) + strTitleCase.substring(1);
        }
    }

    public static void beautifyString(String str) {
        String beautify = addFullStop(str);
        String beautified = capitaliseFirstLetter(beautify);

        System.out.println(beautified);
    }
}
