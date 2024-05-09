package chineduTasks;

import java.util.*;

public class ModeObjects {
    public static Map<String, Integer> modeObjectOf(int... numbers) {
        Map<String, Integer> result = new HashMap<String, Integer>();
        List<Integer> seen = new ArrayList<Integer>();

        for (int number : numbers) {
            if (seen.contains(number)) continue;
            int count = 0;
            for (int num : numbers) if (num == number) count++;
            result.put(String.valueOf(number), count);
            seen.add(number);
        }

        return result;
    }
}
