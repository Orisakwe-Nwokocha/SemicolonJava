package lambdas.functionalInterfaces;

import java.util.function.BiPredicate;

public class BiPredicateSample {
    public static void main(String[] args) {
        BiPredicate<String, Double> predicate = (word, number) -> {
            int length = word.length();
            System.out.println(length);
            double value = length / 2.0;
            System.out.println(value);

            return value >= number;
        };
        
        System.out.println(predicate.test("Sample", 5.0));
        System.out.println(predicate.test("Some string", 5.0));
    }
}
