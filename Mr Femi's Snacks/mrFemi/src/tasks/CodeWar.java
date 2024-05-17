package mrFemi.tasks;

public class CodeWar {
    public static void main(String[] args) {
        System.out.println(findMinAbsDifferenceOf(3, 2, new int[]{1, 3, 7, 4, 6, 2, 5, 3, 8}));
        System.out.println(findMinAbsDifferenceOf(3, 2, new int[]{1, 3, 2, 4, 6, 2, 5, 3, 8}));
    }

    public static int findMinAbsDifferenceOf(int x, int y, int... numbers) {
        int xIndex = -1;
        int yIndex = -1;
        int difference = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;

        for (int index = 0; index < numbers.length; index++) {
            xIndex = numbers[index] == x ? index : xIndex;
            yIndex = numbers[index] == y ? index : yIndex;

            if (xIndex != -1 && yIndex != -1) difference = Math.abs(xIndex - yIndex);
            if (difference < min) min = difference;
        }

        return min;
    }
}
