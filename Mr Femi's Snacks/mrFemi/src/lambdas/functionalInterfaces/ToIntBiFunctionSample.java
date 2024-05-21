package lambdas.functionalInterfaces;

import java.util.function.ToIntBiFunction;

public class ToIntBiFunctionSample {
    public static void main(String[] args) {
        ToIntBiFunction<String, String> toIntBiFunction = String::compareTo;
        int result = toIntBiFunction.applyAsInt("Sample", "SamplE");
        System.out.println("Sample compared to SamplE ==> " +result);
    }
}
