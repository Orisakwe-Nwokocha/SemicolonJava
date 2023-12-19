import java.util.Arrays;

public class RunningTotalArray {

	public static void main(String[] args) {

	int[] array = {1, 2, 3, 4, 5};

	System.out.println(Arrays.toString(runningTotal(array)));


   }
	public static int[] runningTotal(int[] numbers) {
		int[] newArray = new int[numbers.length];
		int sum = 0, count = 0;

		for (int index = 0; index < numbers.length; index++) {
			newArray[count] = numbers[index] + sum;
			sum += numbers[index];
			count++;
		}

		return newArray;
	}

}




