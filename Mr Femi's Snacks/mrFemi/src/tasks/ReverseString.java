package mrFemi.tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseString {
    public static String reverse(String string) {
        if (string == null || string.isBlank()) throw new IllegalArgumentException("String is null or empty");
        String[] split = string.split(" ");
        String reversed = "";
        for (int index = split.length -1; ; index--) {
            if (index == 0) return reversed += split[index];
            reversed += split[index] + " ";
        }
    }

    public static String reverseWithCustomSplit(String string) {
        if (string == null || string.isBlank()) throw new IllegalArgumentException("String is null or empty");
        String[] split = split(string);
        System.out.println(Arrays.toString(split));
        String reversed = "";
        for (int index = split.length -1; ; index--) {
            if (index == 0) return reversed += split[index];
            reversed += split[index] + " ";
        }
    }

    private static String[] split(String string) {
        List<String> split = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        int counter = 0;
        for (int i = 0; ; i++) {
            char c = string.charAt(i);
            if (c != ' ') str.append(c);
            if (c == ' ') {
                split.add(str.toString());
                str = new StringBuilder();
            }
            counter++;
            if (counter == string.length()){
               split.add(str.toString());
                return split.toArray(new String[0]);
            }
        }
    }
}
