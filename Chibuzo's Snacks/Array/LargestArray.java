import java.util.Arrays;

public class LargestArray {
	public static void main(String... args){
		int[] array = {2, 5, 3, 7, 4};
		int[] largestElementResult = largestElementArray(array);
		System.out.println(Arrays.toString(largestElementResult));

		int[] array2 = {-4, 543, -100, 4500, 64};
		int largestElementResult2 = largestElement(array2);
		System.out.println(largestElementResult2);
	}


	public static int[] largestElementArray(int[] numbers){
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
	public static int largestElement(int[] numbers){
		int largestNumber = numbers[0];
		for (int index = 0; index < numbers.length; index++){
			if (numbers[index] > largestNumber){
				largestNumber = numbers[index];
			}
		}
		return largestNumber;

	}
}
