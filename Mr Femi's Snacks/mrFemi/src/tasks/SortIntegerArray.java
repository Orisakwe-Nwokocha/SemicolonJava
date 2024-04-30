package mrFemi.tasks;

import java.util.ArrayList;
import java.util.List;

public class SortIntegerArray {
    private static List<Integer> duplicateChecker;
    private static int[] positions;

    public static int[] sort(int... numbers) {
        validate(numbers);
        duplicateChecker = new ArrayList<>();
        positions = new int[numbers.length];
        int counter = 0;
        for (int number : numbers) {
            if (duplicateChecker.contains(number)) throw new IllegalArgumentException("Duplicate number: " + number);
            duplicateChecker.add(number);
            positions[counter++] = getPositionOf(number, numbers, false);
        }

        return positions;
    }

    public static int[] sortReverse(int... numbers) {
        validate(numbers);
        int counter = 0;
        positions = new int[numbers.length];
        duplicateChecker = new ArrayList<>();

        for (int number : numbers) {
            if (duplicateChecker.contains(number)) throw new IllegalArgumentException("Duplicate number: " + number);
            duplicateChecker.add(number);
            positions[counter++] = getPositionOf(number, numbers, true);
        }

        return positions;
    }

    private static int getPositionOf(int number, int[] numbers, boolean reverse) {
        if (reverse) return getPositionOf(number, numbers);
        int position = 1;
        for (int num : numbers) if (number > num) position++;
        return position;
    }

    private static int getPositionOf(int number, int[] numbers) {
        int position = 1;
        for (int num : numbers) if (number < num) position++;
        return position;
    }

    private static void validate(int[] numbers) {
        if (numbers == null || numbers.length == 0) throw new IllegalArgumentException("Input array is null or empty");
    }
}
