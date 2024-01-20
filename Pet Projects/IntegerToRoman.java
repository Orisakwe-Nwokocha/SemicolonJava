public class IntegerToRoman {
    public static String intToRoman(int number) {
        String[] symbols = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int[] values = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};

        String roman = "";
        int index = values.length - 1;

        while (number > 0) {
            while (number >= values[index]) {
                roman += symbols[index];
                number -= values[index];
            }

            index--;
        }

        return roman;
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(998));

    }
}
