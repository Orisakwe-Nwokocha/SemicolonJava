public class Assumption {
	public static void main(String... args) {
	
	int i = 2;
	int j = 3;
	int k = 2;
	int m = 2;
	
	System.out.println(i == 2); // true

	System.out.println(j == 5); // false

	System.out.println((i >= 0) && (j <= 3)); // true
	
	System.out.println((m <= 100) & (k <= m)); // true

	System.out.println((j >= i) || (k != m)); // true

	System.out.println((k + i < j) | (4 - j >= k)); // false

	System.out.println(!(k > j)); // true

}
}