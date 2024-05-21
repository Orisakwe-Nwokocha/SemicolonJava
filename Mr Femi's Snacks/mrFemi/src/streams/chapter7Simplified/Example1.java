package streams.chapter7Simplified;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Example1 {
    public static void main(String[] args) {
        int[] values = {3, 10, 6, 1, 4, 8, 2, 5, 9, 7};
//        int[] values = {};

        System.out.printf("Min: %d%n",
                IntStream.of(values).min().orElse(-2343567));

        System.out.println(Arrays.stream(values)  .sum());

        System.out.println(IntStream.of(values).reduce(0, Integer::sum));

        System.out.println(Arrays.stream(values)
                .reduce(1, (previous, next)-> previous * next));

        System.out.printf("Product via reduce method: %d%n",
                IntStream.of(values)
                        .reduce((previous, next)-> previous * next)
                        .getAsInt());

        System.out.printf("Values displayed in sorted order: %s%n",
                IntStream.of(values).sorted().boxed().toList());

        System.out.printf("Values displayed in sorted order: %s%n",
                IntStream.of(values).sorted()
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(" ")));

        IntSummaryStatistics summaryStatistics = IntStream.of(values).summaryStatistics();
        System.out.println(summaryStatistics);
        summaryStatistics.accept(2);
        System.out.println(summaryStatistics);



    }
}
