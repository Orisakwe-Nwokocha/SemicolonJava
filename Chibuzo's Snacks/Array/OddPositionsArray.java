public class OddPositionsArray {
    public static void main(String[] args) {
        int[] numbersToPrint = {4, 5, 93, 378, 27, 82, 1};
        oddPositions(numbersToPrint);
    }
    public static void oddPositions(int[] numbers){
        for (int index = 0; index < numbers.length; index += 2){
            System.out.print(numbers[index] + " ");
        }
    }
}
