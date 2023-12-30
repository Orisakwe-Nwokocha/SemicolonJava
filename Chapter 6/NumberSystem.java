public class NumberSystem {
    public static void main(String[] args) {

        System.out.println("Decimal\t      Binary\t      Octal      Hexadecimal");
        System.out.println("------------------------------------------------------");

        for (int i = 1; i <= 256; i++) {
            String binary = Integer.toBinaryString(i);
            String octal = Integer.toOctalString(i);
            String hexadecimal = Integer.toHexString(i);

            System.out.printf("%d\t\t%-9s       %-4s\t      %-4s%n", i, binary, octal, hexadecimal);
        }
    }
}
