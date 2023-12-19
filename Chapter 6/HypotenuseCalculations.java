public class HypotenuseCalculations {
    public static void main(String[] args) {
        System.out.println("The length of the hypotenuse for the first triangle is " + hypotenuse(3.0, 4.0));
        System.out.println("The length of the hypotenuse for the second triangle is " + hypotenuse(5.0, 12.0));
        System.out.println("The length of the hypotenuse for the third triangle is " + hypotenuse(8.0, 15.0));

        System.out.println(Math.hypot(3.0, 4.0));
        System.out.println(Math.hypot(5.0, 12.0));
        System.out.println(Math.hypot(8.0, 15.0));

    }
    public static double hypotenuse(double side1, double side2) {
        return Math.sqrt(square(side1, side2));
    }
    public static double square(double side1, double side2) {
        side1 *= side1;
        side2 *= side2;
        return side1 + side2;
    }

}
