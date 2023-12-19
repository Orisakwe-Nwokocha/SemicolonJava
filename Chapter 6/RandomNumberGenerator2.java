import java.security.SecureRandom;
public class RandomNumberGenerator2 {
    public static void main(String[] args) {
        SecureRandom randomNumbers = new SecureRandom();

        int randomTriple = 3 * randomNumbers.nextInt(5);
        int randomPower = (int) Math.pow(2, randomNumbers.nextInt(6));
        int randomTen = 10 * randomNumbers.nextInt(1, 5);

    }
}
