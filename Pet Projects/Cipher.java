package mrFemi;

public class Cipher {
    public static void main(String[] args) {
        System.out.println(cipher("SERR PBQR PNZC"));
        System.out.println(cipher("SeRr PBQR PNZC"));
        System.out.println(cipher("GUR DHVPX OEBJA SBK WHZCF BIRE GUR YNML QBT."));

    }

    public static String cipher(String text) {
        final int SHIFT = 13;
        StringBuilder cipher = new StringBuilder();

        for (char character : text.toCharArray()) {
            if (!Character.isLetter(character)) {
                cipher.append(character);
                continue;
            }

            int codePoint = character;
            boolean isAfterM = (Character.isLowerCase(character) && character > 'm') || (Character.isUpperCase(character) && character > 'M');
            codePoint = isAfterM ? codePoint - SHIFT : codePoint + SHIFT;
            cipher.appendCodePoint(codePoint);
        }

        return cipher.toString();
    }

}
