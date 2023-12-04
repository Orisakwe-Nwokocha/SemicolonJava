import java.security.SecureRandom;

public class NumberGenerator {

	public static void main(String[] args) {

	SecureRandom random = new SecureRandom();

	int generate = random.nextInt(1, 6);

	System.out.print(generate);
}
}