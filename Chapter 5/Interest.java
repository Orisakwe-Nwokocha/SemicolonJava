public class Interest {
    public static void main(String[] args) {
        double principal = 1000;
        double rate;
        int year;
        double amount = 0;

        System.out.printf("%s%10s%20s%n", "Year", "Rate", "Amount on deposit");
        for (rate = 5; rate <= 10; rate++) {
            for (year = 1; year <= 10; year++) {
               amount = principal * Math.pow(1.0 + rate / 100.0, year);
                System.out.printf("%4d%10.2f%,20.2f%n", year, rate, amount);
            }
            if (rate == 10) {
                break;
            }
            System.out.printf("\n%s%10s%20s%n", "Year", "Rate", "Amount on deposit");

        }
    }
}
