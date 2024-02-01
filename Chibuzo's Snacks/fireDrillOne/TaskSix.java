package fireDrillOne;

public class TaskSix {
    public static void main(String[] args) {
        int multiple = 1;

        for (int counter = 1; counter <= 10; counter++) {
            for (int count = 0; count < 5; count++) {
                if (counter % 4 == 0) {
                    System.out.printf("%d ", (multiple *= counter));

                }
            }
            if (counter % 4 == 0) {
                System.out.print(" ");
                multiple = 1;
            }
        }
    }

}
