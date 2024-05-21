package lambdas.functionalInterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerSample {
    public static void main(String[] args) {
        Consumer<Integer> consumer = System.out::println;

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        numbers.forEach(consumer);
    }

    public static Consumer getConsumer() {
        return System.out::println;
    }
}
