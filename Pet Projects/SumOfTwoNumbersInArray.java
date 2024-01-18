import java.util.Arrays;

public class SumOfTwoNumbersInArray {
    public static void twoSum(int[] nums, int target) {
	int[] newArr = new int[nums.length];
	int[] newArray = new int[2];

	boolean condition = false;
      
        for (int i = 0; i < nums.length; i++) {
            for (int index = 1; index < nums.length; index++) {
                if (nums[i] + nums[index] == target && i != index) {
		    newArr[index] = nums[index];
		    newArr[index + 1] = nums[index + 1];
			
                    newArray[0] = i;
                    newArray[1] = index;
			
                    condition = true;	      	
           	}
            }
	    if (condition) break;
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

	int[] d = {3,2,3};
	twoSum(d, 6);
	    
	int[] e = {1,3,4,2};
	twoSum(e, 6);
    }
}
