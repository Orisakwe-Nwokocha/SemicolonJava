import java.util.Arrays;

public class ConcatenateTwoListsAlternatinglyArray {
    public static void main(String[] args) {
        int[] firstList = {0, 1, 2, 3, 4};
        int[] secondList = {5, 6, 7, 8, 9};

        int[] newList = ConcatenateTwoListsAlternatinglyArray.concatenateTwoListsAlternatinglyInt(firstList, secondList);

        System.out.println(Arrays.toString(newList));
    }
    public static int[] concatenateTwoListsAlternatinglyInt(int[] firstArray, int[] secondArray){
        int length = firstArray.length + secondArray.length;
        int[] newArray = new int[length];
        int count = 0;
        int counter = 1;

        for (int index = 0; index < firstArray.length ; index++) {
            newArray[count] = firstArray[index];
            count += 2;
        }
        for (int index = 0; index < secondArray.length; index++) {
            newArray[counter] = secondArray[index];
            counter += 2;
        }

        return newArray;
    }
    public static String[] concatenateTwoListsAlternatinglyStr(String[] firstArray, String[] secondArray){
        String[] newArray = new String[firstArray.length + secondArray.length];
        int count = 0;
        int counter = 1;

        for (int index = 0; index < firstArray.length; index++) {
            newArray[count] = firstArray[index];
            count += 2;
        }
        for (int index = 0; index < secondArray.length; index++) {
            newArray[counter] = secondArray[index];
            counter += 2;
        }

        return newArray;
    }

}
