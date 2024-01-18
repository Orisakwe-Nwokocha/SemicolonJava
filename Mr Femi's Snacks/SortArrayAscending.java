import java.util.Arrays;

public class SortArrayAscending {
    public static void main(String[] args) {
       int[] numbers = {7, -2, 0, 78, 4, 3, 9};

	for (int count = 0; count < numbers.length; count++) {
		for (int index = 0; index < numbers.length - 1; index++) {
			if (numbers[index] > numbers[index + 1]) {
				int placeholder = numbers[index];
				numbers[index] = numbers[index + 1];
				numbers[index + 1] = placeholder;
			}
		}
	}
	System.out.println(Arrays.toString(numbers));
	    
    }
}
