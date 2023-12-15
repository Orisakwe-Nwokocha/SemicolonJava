public class SumOfNumbersArray {
    public static void main(String[] args) {
        int[] numbersToSum = {1, 2, 3, 4, 5};
        int numbersSummed = SumOfNumbersArray.sumOfNumbersForLoop(numbersToSum);
        System.out.println(numbersSummed);

    }
    public static int sumOfNumbersForLoop(int[] numbers){
        int sum = 0;
        for (int index = 0; index < numbers.length; index++) {
            sum += numbers[index];
        }
        return  sum;
    }
    public static int sumOfNumbersWhileLoop(int[] numbers) {
        int count = 0;
        int sum = 0;
        while (count < numbers.length) {
            sum += numbers[count];
            count++;
        }
        return sum;
    }
    public static int sumOfNumbersDoWhileLoop(int[] numbers) {
        int count = 0;
        int sum = 0;
        do {
            sum += numbers[count];
            count++;

        } while (count < numbers.length);

        return sum;
    }
}
