public class PrimeNumbersMethod {
    public static void main(String[] args) {

        int count = 0;
        for (int num = 1; num < 10_000; num++) {
            if (isPrimeNumber(num)) {
                count++;
                System.out.println(num + " is a prime number");
            } else {
                System.out.println(num + " is not a prime number");
            }
        }

        System.out.println("\nThe number of prime numbers up to 10,000 is: " + count);

    }

    public static boolean isPrimeNumber(int number) {
        int counter = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                counter++;
            }
        }

        if (counter == 2) {
            return true;
        }
        else {
            return false;
        }

    }
}
