package lambdas.functionalInterfaces;

import java.util.function.BiFunction;

public class BiFunctionSample {
    public static void main(String[] args) {
        BiFunction<String, Integer, Boolean> biFunction = (word, number)-> word.length() >= number;

        Boolean result = biFunction.apply("Sample", 5);
        System.out.println("Result ===> " + result);

        result = biFunction.apply("Sample.", 10);
        System.out.println("Result ===> " + result);
    }
}
