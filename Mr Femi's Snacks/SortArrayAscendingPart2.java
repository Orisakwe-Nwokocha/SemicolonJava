import java.util.Arrays;

public class SortArrayAscendingPart2 {
    public static void main(String[] args) {
       int[] numbers = {7, -2, 0, 78, 4, 3, -96, -872, -56, 6, 9, -100, 0, 89};

	for (int index1 = 0; index1 < numbers.length; index1++) {
		for (int index2 = 0; index2 < numbers.length; index2++) {
			if (numbers[index2] > numbers[index1]) {				
				numbers[index1] += numbers[index2]; 
				numbers[index2] = numbers[index1] - numbers[index2];
				numbers[index1] -=  numbers[index2];
			}
		}
	}

	System.out.println(Arrays.toString(numbers));

    }
}
