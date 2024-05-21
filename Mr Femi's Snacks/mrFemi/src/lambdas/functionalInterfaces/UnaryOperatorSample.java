package lambdas.functionalInterfaces;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class UnaryOperatorSample {
    public static void main(String[] args) {
        UnaryOperator<String> firstOperator = (mide) -> mide.concat(" <3 orisha");
        UnaryOperator<String> secondOperator = (string) -> string.concat(" :)");

        Function<String, String> function = firstOperator.andThen(secondOperator);
        System.out.println(function.apply("ara"));
    }
}
