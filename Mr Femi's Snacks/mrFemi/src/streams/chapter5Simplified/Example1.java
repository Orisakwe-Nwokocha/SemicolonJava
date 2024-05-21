package streams.chapter5Simplified;

import java.util.stream.IntStream;

import static java.lang.System.out;
import static lambdas.functionalInterfaces.BooleanSupplierSample.isPrime;

public class Example1 {
    public static void main(String[] args) {
        IntStream.rangeClosed(1, 5)
                .forEach(number -> out.println(isPrime(number)));
    }
}
