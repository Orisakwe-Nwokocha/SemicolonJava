import java.util.Arrays;

public class EvenPositionsArray {
    public static void main(String[] args) {
        int[] numbersToPrint = {4, 5, 93, 378, 27, 82, 1};

        int[] newEvenNumbersArray = evenPositions(numbersToPrint);
        System.out.println(Arrays.toString(newEvenNumbersArray));
    }
    public static int[] evenPositions(int[] numbers){
        int evenPositionsLength = (numbers.length) / 2;
        int[] evenPositionsArray = new int[evenPositionsLength];
        int count = 0;

        for (int index = 1; index < numbers.length; index += 2){
            evenPositionsArray[count] = numbers[index];
            count++;
        }
        return evenPositionsArray;
    }
}

