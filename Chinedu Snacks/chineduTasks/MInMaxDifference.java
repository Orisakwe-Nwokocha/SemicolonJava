package chineduTasks;

import java.util.Arrays;

public class MInMaxDifference {
    public static int[] findMinMaxDifferenceOf(int... numbers) {
        int min = numbers[0];
        int max = numbers[0];

        for (int number : numbers) {
            if (number < min) min = number;
            if (number > max) max = number;
        }
        return new int[] {max - min};
    }
}
