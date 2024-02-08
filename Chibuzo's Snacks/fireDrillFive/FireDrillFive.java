package fireDrillFive;

public class FireDrillFive {
    public static int[] doubleTheLengthOf(int[] inputArray) {
        return new int[inputArray.length * 2];
    }

    public static int[] populateAndDoubleTheDuplicatedElementsOf(int[] inputArray) {
        int[] outputArray = doubleTheLengthOf(inputArray);

        for (int index = 0; index < inputArray.length; index += 2) {
            outputArray[index] = inputArray[index];
            outputArray[index + inputArray.length] = inputArray[index] * 2;

            try {
                outputArray[index + 1] = inputArray[index + 1];
                outputArray[(index + 1) + inputArray.length] = inputArray[index + 1] * 2;
            }
            catch (ArrayIndexOutOfBoundsException ignored) {
            }
        }

        return outputArray;
    }

}
