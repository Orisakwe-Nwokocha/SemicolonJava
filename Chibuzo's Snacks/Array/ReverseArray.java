import java.util.Arrays;
public class ReverseArray {

    public static void main(String[] args) {
        int[] array = {2, 5, 3, 7, 4};

        int[] reversedArray = reverseList(array);

        System.out.print(Arrays.toString(reversedArray));
    }
    public static int[] reverseList(int[] numbers){
        int[] newArray = new int[numbers.length];
        int count = 0;
        for (int index = numbers.length - 1; index >= 0; index--){
            newArray[count] = numbers[index];
            count++;
        }
        return newArray;
    }
}
