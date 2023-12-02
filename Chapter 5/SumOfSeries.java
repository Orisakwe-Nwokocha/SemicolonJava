public class SumOfSeries {

	public static void main(String[] args) {
	
	long sum = 0;
	long i = 0;	

	System.out.printf("n\tSum%n");

	for (i = 1; i <= 100; i++){
		sum += i;
		System.out.printf("%d\t%d%n", i, sum);
	}
	

   }

}
