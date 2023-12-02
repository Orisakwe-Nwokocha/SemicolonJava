public class IntegersDivisibleBy3 {

	public static void main(String[] args) {
	
	int sum = 0;
	int i = 0;	

	for (i = 1; i <= 30; i++){
		if (i % 3 == 0) {
			sum += i;
		System.out.print(i + ", ");
		}
	}
	
	System.out.printf("%nThe sum of those integers between 1 and 30 that are divisible by 3 is: %d%n", sum);

   }

}
