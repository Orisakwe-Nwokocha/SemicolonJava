package lambdas.functionalInterfaces;

import java.util.Random;
import java.util.function.Supplier;

public class SupplierSample {
    public static void main(String[] args) {
        Supplier<Integer> supplier = () -> new Random().nextInt(11) * 2;
        System.out.println(supplier.get());
    }
}
