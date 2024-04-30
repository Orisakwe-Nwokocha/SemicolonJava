package mrFemi;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(calculateEx(3, 3));
        System.out.println(pow(2.71828, 3));
        System.out.println(factorial(5));
        System.out.println(constantE(3));
        System.out.println(constantE(5));
        System.out.println(constantE(10000));
        System.out.println("My exponential");
        System.out.println(constantEx(3));
        System.out.println(constantEx(5));
        System.out.println(constantEx(10000));
        System.out.println("Java exponential");
        System.out.println(Math.exp(3));
        System.out.println(Math.exp(5));
        System.out.println(Math.exp(10000));

    }

    public static int factorial(int n) {
        if (n <= 0) return 1;
        return n * factorial(n-1);
    }

    public static double constantE(int n) {
        if (n <= 0) return 1;

        double e = 1;

        for (int i = 1; i <= n; i++) {
            e += 1.0 / (double) factorial(i);
        }
//        double scale = Math.pow(10, 1);
//        return Math.round(e * scale) / scale;
        return e;
    }

    public static double constantEx(int n) {
        if (n <= 0) return 1;
        return Math.pow(constantE(n), n);
//        double e = 1;
//
//        for (int i = 1; i <= n; i++) {
//            e += pow(n, i) / factorial(i);
//        }
//        return e;

    }

    public static double calculateEx(double x, int n) {
        double sum = 1.0; // Initialize the sum with the first term (1)

        for (int i = 1; i <= n; i++) {
            double term = Math.pow(x, i) / factorial(i);
            sum += term;
        }

        return sum;
    }

    private static double pow(double base, int power) {
        double product = 1;
        for (int i = 1; i <= power; i++) {
            product *= base;
        }
        return product;
    }


}
