public class SumOfNaturalNumbers {
    public static void main(String[] args) {
        
	int sum = 0;

	for (int count = 1; count <= 10; count++) {
		sum += count;
	}
	
	System.out.printf("%nThe sum of the first ten natural numbers is: %d%n", sum);
    }
}
