package fireDrillOne;

public class TaskFive {
    public static void main(String[] args) {
        for (int counter = 1; counter <= 10; counter++) {
            for (int count = 0; count < 5; count++) {
                if (counter % 4 == 0) System.out.printf("%d", counter);
            }
            if (counter % 4 == 0) System.out.print(" ");
        }
    }
}
