import java.util.Arrays;

public class LargestArray {
	public static void main(String... args){
		int[] array = {2, 5, 3, 7, 4};
		int[] largestElementResult = largestElement(array);
		System.out.println(Arrays.toString(largestElementResult));
	}


	public static int[] largestElement(int[] numbers){
		int largest = numbers[0];
		int[] newArray = new int[1];
		for (int index = 0; index < numbers.length; index++){
			if (numbers[index] > largest){
				largest = numbers[index];
			}
		}
		newArray[0] = largest;
		return newArray;

	}
}
