package lambdas.functionalInterfaces;

import java.util.Map;
import java.util.function.ObjIntConsumer;

public class ObjIntConsumerSample {
    public static void main(String[] args) {
        ObjIntConsumer<String> objIntConsumer = (word, num)-> System.out.println(word + " ==> " + num);

        Map<String, Integer> map = Map.of(
                "key1", 89,
                "key2", 6,
                "key3", 78
        );

        map.forEach(objIntConsumer::accept);
    }
}
