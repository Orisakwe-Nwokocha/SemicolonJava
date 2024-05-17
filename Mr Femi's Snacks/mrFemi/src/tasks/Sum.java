package mrFemi.tasks;

import java.util.ArrayList;
import java.util.List;

public class Sum {
    public static int add(int firstNumber, int secondNumber) {
        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(firstNumber);
        numbers.add(secondNumber);
        return  numbers.stream().mapToInt(number -> number).sum();

    }

    public static int add2(int firstNumber, int secondNumber) {
        int flag = firstNumber;
        int result = secondNumber;

        if (firstNumber <= 0) {
            flag = secondNumber;
            result = firstNumber;
        }
        if (firstNumber <= 0 && secondNumber <= 0) return add2Inverted(result, flag);
        for (int counter = 0; counter < flag; counter++) result++;

        return result;

    }

    private static int add2Inverted(int result, int flag) {
        flag *= -1;
        result *= -1;
        for (int counter = 0; counter < flag; counter++) result++;
        return result *= -1;
    }
}
