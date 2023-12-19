public class ZereodCodeArray {
    public static int[] zeroedCode(int[] numbers) {
        numbers[0] = 0;
        numbers[numbers.length - 1] = 0;

        return numbers;
    }
}
