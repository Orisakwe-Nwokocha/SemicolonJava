package lambdas.functionalInterfaces;

import item.Item;

import java.util.List;
import java.util.function.ToDoubleFunction;
import java.util.stream.Stream;

import static lambdas.functionalInterfaces.ConsumerSample.getConsumer;
import static lambdas.functionalInterfaces.DoubleConsumerSample.getDoubleConsumer;

public class ToDoubleFunctionSample {
    public static void main(String[] args) {
        ToDoubleFunction<Item> toDoubleFunction = (item) -> item.getPrice() * item.getQuantity();

        Stream<Item> itemStream = Stream.of(
                new Item(2500, 2),
                new Item(540.57, 4),
                new Item(1000, 3),
                new Item(890.35, 6)
        );

        List<Double> list = itemStream.mapToDouble(toDoubleFunction).boxed().toList();

        for (Double value : list) getDoubleConsumer().accept(value);

        list.forEach(getConsumer());
    }
}
