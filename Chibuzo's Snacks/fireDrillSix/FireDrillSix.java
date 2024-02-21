package fireDrillSix;

public class FireDrillSix {
    public static int[] modifyIntegers(int[] numbers) {
        for (int index = 0; index < numbers.length; index+= 2) {
            //numbers[index] = numbers[index] % 2;

            numbers[index] = numbers[index] % 2 == 0 ? 0 : 1;
            try {
                numbers[index + 1] = numbers[index + 1] % 2 == 0 ? 0 : 1;
            }
            catch (ArrayIndexOutOfBoundsException ignored){}
        }

        return numbers;
    }



}
