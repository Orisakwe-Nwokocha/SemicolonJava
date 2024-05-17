package mrFemi.chapter16;

import java.util.*;

public class Example1 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(4);

        System.out.println(numbers);


        Set<Integer> set = new HashSet<>(numbers);
        System.out.println(set);

        int[] numbers2 = {1, 2, 1, 3, 1, 3, 4, 5};
        System.out.println(Arrays.toString(numbers2));
        Set<Integer> set2 = new HashSet<>(Arrays.stream(numbers2).boxed().toList());
        System.out.println(set2);

    }
}
