public class Anagram {
    public static void main(String[] args) {
        String anagram1 = "Coronavirus";
        String anagram2 = "carNivorous";
        String anagram3 = "ANAGRAM";
        String anagram4 = "nag a ram";

        if (isAnagram(anagram1, anagram2)) System.out.printf("%s is an anagram of %s%n", anagram1, anagram2);
        else System.out.printf("%s is not an anagram of %s%n", anagram1, anagram2);
        if (isAnagram(anagram3, anagram4)) System.out.printf("%s is an anagram of %s%n", anagram3, anagram4);
        else System.out.printf("%s is not an anagram of %s%n", anagram3, anagram4);

    }

    public static boolean isAnagram(String phrase1, String phrase2) {
        phrase1 = phrase1.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        char[] c = new char[phrase1.length()];

        int counter = 0;
        for (int count = 0; count < phrase1.length(); count++) {
            c[counter] = phrase1.charAt(count);
            counter++;
        }

        for (int index = 0; index < c.length; index++) {
            for (int elements = 0; elements < c.length - 1; elements++) {
                if (c[elements] > c[elements + 1]) {
                    char placeholder = c[elements];
                    c[elements] = c[elements + 1];
                    c[elements + 1] = placeholder;
                }
            }
        }

        phrase2 = phrase2.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        char[] d = new char[phrase2.length()];

        int counter2 = 0;
        for (int count = 0; count < phrase2.length(); count++) {
            d[counter2] = phrase2.charAt(count);
            counter2++;
        }

        for (int index = 0; index < d.length; index++) {
            for (int elements = 0; elements < d.length - 1; elements++) {
                if (d[elements] > d[elements + 1]) {
                    char placeholder = d[elements];
                    d[elements] = d[elements + 1];
                    d[elements + 1] = placeholder;
                }
            }
        }

        String phrase1Modified = new String(c);
        String phrase2Modified = new String(d);

        if (phrase1Modified.length() != phrase2Modified.length()) {
            return false;
        } else return phrase1Modified.equals(phrase2Modified);

    }
}
