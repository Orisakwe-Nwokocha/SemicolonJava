import java.util.Arrays;

public class ConcatenateTwoListsArray {
    public static void main(String[] args) {
        int[] firstList = {1, 2, 3, 4};
        int[] secondList = {5, 6, 7, 8, 9};

        int[] newList = ConcatenateTwoListsArray.concatenateTwoListsInt(firstList, secondList);

        System.out.println(Arrays.toString(newList));
    }
    public static int[] concatenateTwoListsInt(int[] firstArray, int[] secondArray){
        int[] newArray = new int[firstArray.length + secondArray.length];
        int count = 0;
        int counter = firstArray.length;

        for (int index = 0; index < firstArray.length; index++) {
            newArray[count] = firstArray[index];
            count++;
        }
        for (int index = 0; index < secondArray.length; index++) {
            newArray[counter] = secondArray[index];
            counter++;
        }
        return newArray;
    }

    public static String[] concatenateTwoListsStr(String[] firstArray, String[] secondArray){
        String[] newArray = new String[firstArray.length + secondArray.length];
        int count = 0;
        int counter = firstArray.length;

        for (int index = 0; index < firstArray.length; index++) {
            newArray[count] = firstArray[index];
            count++;
        }
        for (int index = 0; index < secondArray.length; index++) {
            newArray[counter] = secondArray[index];
            counter++;
        }
        return newArray;
    }
}
