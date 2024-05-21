package lambdas.functionalInterfaces;

import java.util.function.LongUnaryOperator;

public class LongUnaryOperatorSample {
    public static void main(String[] args) {
        LongUnaryOperator longUnaryOperator = (number) -> number * 2;
        System.out.println(longUnaryOperator.applyAsLong(3327672674260L));
    }
}
