package lambdas.functionalInterfaces;

import java.util.function.IntToDoubleFunction;

public class IntToDoubleFunctionSample {
    public static void main(String[] args) {
        IntToDoubleFunction intToDoubleFunction = (number)-> Integer.valueOf(number).doubleValue();
        System.out.println(intToDoubleFunction.applyAsDouble(69));
    }
}
