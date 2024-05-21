package lambdas.functionalInterfaces;

import java.util.function.BinaryOperator;

public class BinaryOperatorSample {
    public static void main(String[] args) {
        BinaryOperator<Integer> binaryOperator = (num1, num2) -> num1 * num2;
        System.out.println(binaryOperator.apply(2, 3));

    }
}
