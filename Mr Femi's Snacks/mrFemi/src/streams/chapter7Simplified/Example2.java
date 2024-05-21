package streams.chapter7Simplified;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Example2 {
    public static void main(String[] args) {
        List<List<Integer>> lists = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5),
                Arrays.asList(10, 20, 30, 40, 50),
                Arrays.asList(100, 200, 300, 400, 500)
        );
        System.out.println(lists);

        List<Integer> list = lists.stream().flatMap(Collection::stream).collect(Collectors.toCollection(ArrayList::new));
//        List<Integer> list = lists.stream().flatMap(Collection::stream).collect(Collectors.toList());
//        List<Integer> list = lists.stream().flatMap(Collection::stream).toList();
        System.out.println(list);
        list.removeFirst();
        System.out.println(list);

    }
}
