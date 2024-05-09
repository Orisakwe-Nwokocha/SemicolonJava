package chineduTasks;

import java.util.*;

public class ModeObjects {
    public static Map<String, Integer> modeObjectOf(int... numbers) {
        Map<String, Integer> result = new HashMap<>();
        List<Integer> uniqueNumbers = new ArrayList<>();

        for (int number : numbers) {
            if (uniqueNumbers.contains(number)) continue;
            int count = 0;
            for (int num : numbers) if (num == number) count++;
            result.put(String.valueOf(number), count);
            uniqueNumbers.add(number);
        }

        return result;
    }
}
