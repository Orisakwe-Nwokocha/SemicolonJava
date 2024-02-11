package integerToWords;

public class IntegerToWords {
    public static String getHourInWords(int hour) {
        return convertIntegerToString(hour);
    }

    public static String getMinuteInWords(int minute) {
        return convertIntegerToString(minute);
    }

    private static String convertIntegerToString(int number) {
        return getOutput(number);
    }

    private static String getOutput(int time) {
        String[] timeInWords = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
                "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
                "Nineteen", "Twenty", "Thirty", "Forty", "Fifty"};
        int[] timeInNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 30, 40, 50};

        StringBuilder output = new StringBuilder();

        for (int index = timeInNumbers.length - 1; index >= 0; index--) {
            boolean timeIsWithinRange = time >= timeInNumbers[index];
            boolean condition = time > 19 && time % 10 != 0;

            if (timeIsWithinRange && condition) {
                output.append(timeInWords[index]).append(" ");
                time -= timeInNumbers[index];
            }

            if (time == timeInNumbers[index]) {
                output.append(timeInWords[index]);
                time -= timeInNumbers[index];
            }
        }

        return output.toString();
    }

    public static String displayTimeInWords(int hour, int minute) {
        if (timeIsNotValid(hour, minute)) throw new IllegalArgumentException("Hour and/or minute was out of range");

        hour = hourFormatter(hour);

        if (minute == 0) return getHourInWords(hour) + " o'clock";
        else if (minute == 15) return "quarter past " + getHourInWords(hour);
        else if (minute < 30) return getMinuteInWords(minute) + " minutes past " + getHourInWords(hour);
        else if (minute == 30) return "half past " + getHourInWords(hour);
        else if (minute == 45) return "quarter to " + getHourInWords(hour == 12 ? 1 : hour + 1);

        return getMinuteInWords(60 - minute) + " minutes to " + getHourInWords(hour == 12 ? 1 : hour + 1);
    }

    private static boolean timeIsNotValid(int hour, int minute) {
        if (hour < 0 || hour > 23) return true;

        return minute < 0 || minute > 59;
    }

    private static int hourFormatter(int hour) {
        if (hour > 12) return hour - 12;
        else if (hour == 0) return 12;

        return hour;
    }
}
