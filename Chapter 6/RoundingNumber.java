public class RoundingNumber {
    public static void main(String[] args) {
        roundToInteger(9.2578);
        roundToTenths(9.2578);
        roundToHundredths(9.2578);
        roundToThousandths(9.2578);

    }
    public static void roundToInteger(double number){
        System.out.printf("Original value of number = %f", number);
        double y = Math.floor(number + 0.5);
        System.out.printf("%nThe number rounded to the nearest integer = %f%n", y);
    }
    public static void roundToTenths(double number){
        System.out.printf("%nOriginal value of number = %f", number);
        double y = Math.floor(number * 10 + 0.5) / 10;
        System.out.printf("%nThe number rounded to the nearest tenth = %f%n", y);
    }
    public static void roundToHundredths(double number){
        System.out.printf("%nOriginal value of number = %f", number);
        double y = Math.floor(number * 100 + 0.5) / 100;
        System.out.printf("%nThe number rounded to the nearest hundredth = %f%n", y);
    }
    public static void roundToThousandths(double number){
        System.out.printf("%nOriginal value of number = %f", number);
        double y = Math.floor(number * 1000 + 0.5) / 1000;
        System.out.printf("%nThe number rounded to the nearest thousandth = %f%n", y);
    }
}
