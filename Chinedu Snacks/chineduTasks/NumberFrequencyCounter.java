package chineduTasks;

import java.util.*;

public class NumberFrequencyCounter {
    public static Map<String, Integer> countFrequencies(int... numbers) {
        Map<String, Integer> result = new HashMap<>();

        for (int number : numbers) {
            if (result.containsKey(String.valueOf(number))) continue;
            Integer count = (int) Arrays.stream(numbers).filter(n -> n == number).count();
            result.put(String.valueOf(number), count);
        }

        return result;
    }
}
