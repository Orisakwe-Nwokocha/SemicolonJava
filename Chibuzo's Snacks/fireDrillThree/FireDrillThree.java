public class FireDrillThree {

    public static int[] taskOne(int... scores) {
        int[] scoresArray = new int[10];
        int index = 0;

        for (int score : scores) {
            scoresArray[index] = score;
            index++;
        }

        return scoresArray;
    }

    public static String taskTwo() {
        int[] scoresArray = taskOne(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        String printScoresVertically = "";

        for (int score : scoresArray) printScoresVertically += score + "\n";

        return printScoresVertically;
    }

    public static String taskThree() {
        int[] scoresArray = taskOne(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        String printScoresHorizontally = "";

        for (int score : scoresArray) printScoresHorizontally += score + " ";

        return printScoresHorizontally;
    }

    public static int[] taskFour(int[] numbers) {
        int[] elementsAtEvenIndexes;
        int length = numbers.length;

        if (length % 2 != 0) elementsAtEvenIndexes = new int[(length / 2) + 1];
        else elementsAtEvenIndexes = new int[length / 2];

        int count = 0;

        for (int index = 0; index < numbers.length; index +=2) {
            elementsAtEvenIndexes[count] = numbers[index];
            count++;
        }

        return elementsAtEvenIndexes;
    }

    public static int[] taskFive(int[] numbers) {
        int[] elementsAtOddIndexes = new int[numbers.length / 2];
        int count = 0;

        for (int index = 1; index < numbers.length; index +=2) {
            elementsAtOddIndexes[count] = numbers[index];
            count++;
        }

        return elementsAtOddIndexes;
    }

    public static int taskSix(int[] numbers) {
        int[] numbersAtEvenIndexes = taskFour(numbers);
        int sum = 0;

        for (int number : numbersAtEvenIndexes) sum += number;

        return sum;
    }

    public static int taskSeven(int[] numbers) {
        int[] numbersAtEvenIndexes = taskFive(numbers);
        int sum = 0;

        for (int number : numbersAtEvenIndexes) sum += number;

        return sum;
    }

    public static int taskEight(int[] numbers) {
        int[] numbersAtEvenIndexes = taskFour(numbers);
        int minimum = numbers[0];

        for (int number : numbersAtEvenIndexes) {
            if (number < minimum) minimum = number;
        }

        return minimum;
    }

    public static int taskNine(int[] numbers) {
        int[] numbersAtOddIndexes = taskFive(numbers);
        int minimum = numbers[0];

        for (int number : numbersAtOddIndexes) {
            if (number < minimum) minimum = number;
        }

        return minimum;
    }

    public static int taskTen(int[] numbers) {
        int[] numbersAtEvenIndexes = taskFour(numbers);
        int maximum = numbers[0];

        for (int number : numbersAtEvenIndexes) {
            if (number > maximum) maximum = number;
        }

        return maximum;
    }

    public static int taskEleven(int[] numbers) {
        int[] numbersAtOddIndexes = taskFive(numbers);
        int maximum = numbers[0];

        for (int number : numbersAtOddIndexes) {
            if (number > maximum) maximum = number;
        }

        return maximum;
    }

    public static int[] taskTwelve(int[] numbers) {
        int[] swappedElements = new int[numbers.length];

        for (int index = 0; index < numbers.length; index+=2) {
                swappedElements[index] = numbers[index + 1];
                swappedElements[index + 1] = numbers[index];
        }

        return swappedElements;
    }

    public static int[] taskThirteen(int[] numbers) {
        int[] swappedElements = new int[numbers.length];

        for (int index = 0; index < numbers.length; index+=2) {
            boolean condition = numbers[index] % 2 == 0 || numbers[index + 1] % 2 == 0;

            if (condition) {
                swappedElements[index] = numbers[index];
                swappedElements[index + 1] = numbers[index + 1];
            } else {
                swappedElements[index] = numbers[index + 1];
                swappedElements[index + 1] = numbers[index];
            }
        }

        return swappedElements;
    }

    public static int[] taskFourteen(int[] numbers) {
        int[] swappedElements = new int[numbers.length];

        for (int index = 0; index < numbers.length; index+=2) {
            boolean condition = numbers[index] % 2 != 0 || numbers[index + 1] % 2 != 0;

            if (condition) {
                swappedElements[index] = numbers[index];
                swappedElements[index + 1] = numbers[index + 1];
            } else {
                swappedElements[index] = numbers[index + 1];
                swappedElements[index + 1] = numbers[index];
            }
        }

        return swappedElements;
    }

    public static int[] taskFifteen(int[] numbers) {
        int[] swappedElements = new int[numbers.length];

        for (int index = 0; index < numbers.length; index+=2) {
            boolean condition = numbers[index] % 2 != 0 && numbers[index + 1] % 2 != 0;

            if (condition) {
                swappedElements[index] = numbers[index];
                swappedElements[index + 1] = numbers[index + 1];
            } else {
                swappedElements[index] = numbers[index + 1];
                swappedElements[index + 1] = numbers[index];
            }
        }

        return swappedElements;
    }

    public static int[] taskSixteen(int[] numbers) {
        int[] swappedElements = new int[numbers.length];

        for (int index = 0; index < numbers.length; index+=2) {
            boolean condition = numbers[index] % 2 == 0 && numbers[index + 1] % 2 == 0;

            if (condition) {
                swappedElements[index] = numbers[index];
                swappedElements[index + 1] = numbers[index + 1];
            } else {
                swappedElements[index] = numbers[index + 1];
                swappedElements[index + 1] = numbers[index];
            }
        }

        return swappedElements;
    }
}
