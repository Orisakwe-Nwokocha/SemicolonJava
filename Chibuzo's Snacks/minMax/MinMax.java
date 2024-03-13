package minMax;

public class MinMax {

    public static int[] firstTry(int... numbers) {
        int[] minMax = new int[2];

        int min = getMinMax(1, numbers);
        int max = getMinMax(2, numbers);

        minMax[0] = getMinMaxSum(max, numbers);
        minMax[1] = getMinMaxSum(min, numbers);

        return minMax;
    }

    public static int[] secondTry(int... numbers) {
        int[] minMax = new int[2];

        int min = Integer.MAX_VALUE;
        int max = numbers[0];

        for(int number : numbers) {
            int sum = 0;
            sum = getSum(numbers, number, sum);
            if(sum < min) min = sum;
            if(sum > max) max = sum;
        }

        minMax[0] = min;
        minMax[1] = max;

        return minMax;
    }

    private static int getSum(int[] numbers, int number, int sum) {
        for(int num : numbers) {
            if(number == num) continue;
            sum += num;
        }
        return sum;
    }

    private static int getMinMax(int flag, int... numbers) {
        if (flag == 1) {
            int min = numbers[0];
            for (int number : numbers) if (number < min) min = number;
            return min;
        }
        else {
            int max = numbers[0];
            for (int number : numbers) if (number > max) max = number;
            return max;
        }
    }

    private static int getMinMaxSum(int flag, int... numbers) {
        int sum = 0;
        for (int number : numbers) {
            if (number == flag) continue;
            sum += number;
        }

        return sum;
    }
}
