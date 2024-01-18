import java.util.Arrays;

public class SumOfTwoNumbersInArray {
    public static void twoSum(int[] nums, int target) {

	int[] newArr = new int[nums.length];
	int[] newArray = new int[2];


	for (int index = 0; index < nums.length - 1; index++) {
        	if (nums[index] + nums[index + 1] == target) {
		    newArr[index] = nums[index];
		    newArr[index + 1] = nums[index + 1];

		    newArray[0] = index;
		    newArray[1] = index + 1;
		}
	}

	System.out.println(Arrays.toString(newArr));
	System.out.println(Arrays.toString(newArray));
    }

    public static void main(String... args) {
	int[] a = {3,2,4, 5};
	twoSum(a, 6);

	int[] b = {2,7,11,15};
	twoSum(b, 9);

	int[] c = {3,3};
	twoSum(c, 6);
    }
}