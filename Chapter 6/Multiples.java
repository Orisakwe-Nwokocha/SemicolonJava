public class Multiples {
    public static void main(String[] args) {
        int firstNum = 7;
        int secondNum = -14;

        boolean isTrue = isMultiple(firstNum, secondNum);
        if (isTrue) {
            System.out.printf("%d is a multiple of %d", secondNum, firstNum);
        } else {
            System.out.printf("%d is not a multiple of %d", secondNum, firstNum);
        }
    }
    public static boolean isMultiple(int num1, int num2) {
        return num2 % num1 == 0;
    }
}
