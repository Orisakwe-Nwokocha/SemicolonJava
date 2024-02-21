package fireDrillSeven;

public class FireDrillSeven {
    public static boolean[] returnBoolean(int[] numbers) {
        boolean[] output = new boolean[numbers.length];

        for (int index = 0; index < numbers.length; index++) output[index] = numbers[index] % 2 != 0;

        return output;
    }
}
