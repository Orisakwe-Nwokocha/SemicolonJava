import java.util.List;

public class PigLatin {
    private static final List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u');
    private String word;

    public PigLatin() {}

    private PigLatin(String word) {
        this.word = word;
    }

    public static String translate(String input) {
        if (input == null || input.isBlank()) throw new IllegalArgumentException("Invalid input");
        input = input.toLowerCase();

        boolean isVowel = vowels.contains(input.charAt(0));
        if (isVowel) return String.format("%sway", input);

        int vowelIndex = getIndex(input);
        if (vowelIndex == -1) return String.format("%say", input);
        return String.format("%s%say", input.substring(vowelIndex), input.substring(0, vowelIndex));
    }

    private static int getIndex(String input) {
        for (int index = 0; index < input.length(); index++) if (vowels.contains(input.charAt(index))) return index;
        return -1;
    }

    public static PigLatin convert(String string) {
        return new PigLatin(string);
    }

    public String toPigLatin() {
        return translate(word);
    }
}
