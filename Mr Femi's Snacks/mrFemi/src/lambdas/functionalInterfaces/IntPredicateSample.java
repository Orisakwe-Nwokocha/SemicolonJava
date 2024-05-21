package lambdas.functionalInterfaces;

import java.util.function.IntPredicate;

public class IntPredicateSample {
    public static void main(String[] args) {
        IntPredicate intPredicate = (number) -> number % 2 == 0;
        System.out.println("2 isEvenNumber: " + intPredicate.test(2));
        System.out.println("3 isEvenNumber: " + intPredicate.test(3));
    }
}
