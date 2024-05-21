package lambdas.functionalInterfaces;

import java.util.Map;
import java.util.function.BiConsumer;

public class BiConsumerSample {
    public static void main(String[] args) {
        BiConsumer<String, Integer> biConsumer = (string, number) -> System.out.println(string + ": " + number);

        Map<String, Integer> words = Map.of(
                "ONE", 1,
                "TWO", 2,
                "THREE", 3
        );

        words.forEach(biConsumer);
    }
}
