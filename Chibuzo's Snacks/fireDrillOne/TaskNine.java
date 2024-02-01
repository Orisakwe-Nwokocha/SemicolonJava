package fireDrillOne;

public class TaskNine {
    public static void main(String[] args) {
        int multiple = 1;
        int sum = 0;


        for (int counter = 1; counter <= 10; counter++) {
            for (int count = 0; count < 5; count++) {
                if (counter % 4 == 0) {
                    sum += (multiple *= counter);
                }
            }

            if (counter % 4 == 0) {
                multiple = 1;
            }
        }

        System.out.printf("%d", sum * sum);
    }
}
