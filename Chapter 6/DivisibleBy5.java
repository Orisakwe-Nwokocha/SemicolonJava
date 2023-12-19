public class DivisibleBy5 {
    public static void main(String[] args) {
        int num1 = 7;
        int num2 = -14;
        int num3 = -15;
        int num4 = 10;
        int num5 = 55;
        int num6 = 9;
        int num7 = 100;
        int num8 = 250;
        int num9 = -43;
        int num10 = -60;
        
        System.out.println(isDivisible(num1));
        System.out.println(isDivisible(num2));
        System.out.println(isDivisible(num3));
        System.out.println(isDivisible(num4));
        System.out.println(isDivisible(num5));
        System.out.println(isDivisible(num6));
        System.out.println(isDivisible(num7));
        System.out.println(isDivisible(num8));
        System.out.println(isDivisible(num9));
        System.out.println(isDivisible(num10));
        
        
    }
    public static boolean isDivisible(int number) {
        if (number % 5 == 0) {
            return true;
        }
        return false;
    }
}
