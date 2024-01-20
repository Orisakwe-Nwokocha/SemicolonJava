public class FactorialRecursion {
    public static void main(String[] args) {
        int result = 0;
        try {
            result = factorial(5);
        }
        catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(result);

        int[] a = {4,2,3,4,5};
        System.out.println(multiply(a, 4));

    }

    public static int factorial(int number) {
        if (number < 0) throw new RuntimeException("Factorial cannot be a negative number");
        else if (number == 0) return 1;
        else {
            return number * factorial(number - 1);
        }
    }

    public static int multiply(int[] numbers, int loop) {
        if (loop < 0) throw new RuntimeException("Factorial cannot be a negative number");
        else if (loop == 0) return 1;
        else {
            System.out.println(loop);
            return numbers[loop - 1] * multiply(numbers, loop - 1);
        }
    }
}
