package lambdas.functionalInterfaces;

import java.util.function.Predicate;

public class PredicateSample {
    public static void main(String[] args) {
        Predicate<String> predicate = (word) -> word.contains("o");
        System.out.println(predicate.test("Sample"));
        System.out.println(predicate.test("Some string"));
    }
}
