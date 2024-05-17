package mrFemi.tasks;

import java.util.ArrayList;
import java.util.List;

public class Isogram {

    public static boolean isIsogram(String string) {
        string = string.replaceAll("(\\s|[0-9])", "").toLowerCase();
        char[] chars = string.toCharArray();
        List<Character> charSet = new ArrayList<>();
        for (char c : chars) if (!charSet.contains(c)) charSet.add(c);
        return charSet.size() == 26;
    }
}
