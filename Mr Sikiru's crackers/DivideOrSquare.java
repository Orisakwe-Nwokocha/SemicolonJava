public class DivideOrSquare {
    public static double divideOrSquare(double number) {
        if (number % 5 == 0) {
            return Math.sqrt(number);
        } else {
            return number % 5;
        }
    }
}
