import java.util.Arrays;

public class ArrayFunctions {
    public static int findTheMaxProductOf(int... numbers) {
        if (numbers.length < 2) return 0;
        int maxProduct = numbers[0];

        for (int index = 0; index < numbers.length; index++) maxProduct = getMaxProduct(numbers, index, maxProduct);
        return maxProduct;
    }

    private static int getMaxProduct(int[] numbers, int index, int maxProduct) {
        for (int index1 = index + 1; index1 < numbers.length; index1++) {
            int product = numbers[index] * numbers[index1];
            if (product > maxProduct) maxProduct = product;
        }
        return maxProduct;
    }

    public static int[] sort(int... numbers) {
        int[] sorted = new int[numbers.length];
        int counter = 0;
        for (int number : numbers) if (number != 0) sorted[counter++] = number;
        return sorted;
    }

    private static void sort1(int... numbers) {
        for (int index1 = 0; index1 < numbers.length; index1++) {
            for (int index2 = 0; index2 < numbers.length; index2++) {
                if (numbers[index1] < numbers[index2]) {
                    int temp = numbers[index1];
                    numbers[index1] = numbers[index2];
                    numbers[index2] = temp;
                }
            }
        }
    }
}
