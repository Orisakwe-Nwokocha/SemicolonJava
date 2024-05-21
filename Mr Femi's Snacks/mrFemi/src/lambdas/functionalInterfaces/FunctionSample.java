package lambdas.functionalInterfaces;

import java.util.function.Function;

public class FunctionSample {
    public static void main(String[] args) {
        Function<String, Boolean> function = (word)-> word.endsWith(".");

        Boolean result = function.apply("Sample");
        System.out.println("Result ===> " + result);

        result = function.apply("Sample.");
        System.out.println("Result ===> " + result);
    }
}
