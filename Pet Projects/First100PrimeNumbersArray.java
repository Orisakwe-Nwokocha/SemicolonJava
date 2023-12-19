import java.util.Arrays;

public class First100PrimeNumbersArray {
    public static void main(String[] args) {
        int[] nums = new int[10];

        System.out.println(Arrays.toString(primeNumbers(nums)));
    }
    public static int[] primeNumbers(int[] numbers) {
            int count = 1;
            int newArrayLength = 0;
            int[] placeholder = new int[numbers.length];
            int placeholderCounter = 0;

            for (int index = 0; index < numbers.length; index++) {
                numbers[index] = count;
                count++;
            }

            for (int index = 0; index < numbers.length; index++) {
                int number = numbers[index];
                int counter = 0;

                for (int i = 1; i <= number; i++) {
                    if (number % i == 0) {
                        counter++;
                    }
                }

                if (counter == 2) {
                    newArrayLength++;
                    placeholder[placeholderCounter] = number;
                    placeholderCounter++;
                }
            }

            int[] newArray = new int[newArrayLength];
            int newArrayCounter = 0;
            for (int index = 0; index < newArray.length; index++) {
                newArray[newArrayCounter] = placeholder[index];
                newArrayCounter++;
            }

            return newArray;
    }


}
