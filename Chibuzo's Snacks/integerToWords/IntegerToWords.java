package integerToWords;

public class IntegerToWords {
    public static String getHourInWords(int hour) {
        return ab(hour);

    }

    private static String ab(int hour) {
        return switch (hour) {
            case 1 -> "One";
            case 2 -> "Two";
            case 3 -> "Three";
            case 4 -> "Four";
            case 5 -> "Five";
            case 6 -> "Six";
            case 7 -> "Seven";
            case 8 -> "Eight";
            case 9 -> "Nine";
            case 10 -> "Ten";
            case 11 -> "Eleven";
            case 12 -> "Twelve";
            default -> throw new IllegalArgumentException("Hour must be between 1 and 12");
        };
    }



    public static String convertIntegerToString(int minute) {
        String[] minuteInWords = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
                "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
                "Nineteen", "Twenty", "Thirty", "Forty", "Fifty"};
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 30, 40, 50};

        String output = "";

        for (int count = 0; count < 2; count++) {

            for (int index = numbers.length - 1; index > 0; index--) {
                if (minute >= numbers[index]) {
                    output += minuteInWords[index] + " ";
                    minute -= numbers[index];
                }
            }
        }

        return output;

    }

/*    boolean condition = minute > 19;

                if (condition && minute >= numbers[index]) {
        output += minuteInWords[index] + "-";
        minute -= numbers[index];
    }
                else if (minute == numbers[index]) {
        output += minuteInWords[index];
        minute -= numbers[index];
    }*/
}
