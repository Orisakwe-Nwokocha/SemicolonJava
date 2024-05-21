package lambdas.functionalInterfaces;

import java.security.SecureRandom;
import java.util.function.BooleanSupplier;

import static java.lang.System.out;

public class BooleanSupplierSample {
    public static void main(String[] args) {
        BooleanSupplier booleanSupplier = () -> isPrime(new SecureRandom().nextInt(101));
        for (int counter = 0; counter < 5; counter++)
            out.println(booleanSupplier.getAsBoolean());
    }

    public static boolean isPrime(int number) {
        out.println("number: " +number);

        if (number < 2) return false;
        if (number < 4) return true;

        for (int factor = 2; factor < Math.sqrt(number); factor++)
            if (number % factor == 0) return false;
        return true;
    }
}
