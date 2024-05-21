package lambdas.functionalInterfaces;

import java.util.function.DoubleConsumer;

public class DoubleConsumerSample {
    public static DoubleConsumer getDoubleConsumer() {
        return (value) -> System.out.println("Value: " + value);
    }
}
