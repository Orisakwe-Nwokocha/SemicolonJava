package lambdas.functionalInterfaces;

import java.util.function.IntConsumer;

public class IntConsumerSample {
    public static void main(String[] args) {
        IntConsumer intConsumer = (number) -> System.out.println(number * 10);
        intConsumer.accept(5);
    }
}
