import java.security.SecureRandom;
public class RandomNumberGenerator {
    public static void main(String[] args) {
        SecureRandom randomNumbers = new SecureRandom();
        int n;
        System.out.println(n = randomNumbers.nextInt(2,7));
        System.out.println(n = randomNumbers.nextInt(4,51));
        System.out.println(n = randomNumbers.nextInt(0,8));
        System.out.println(n = randomNumbers.nextInt(1000,1031));
        System.out.println(n = randomNumbers.nextInt(-5,2));
        System.out.println(n = randomNumbers.nextInt(-2,10));


    }
}
