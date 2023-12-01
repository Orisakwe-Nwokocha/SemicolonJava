public class StopWatchExample {
    public static void main(String[] args) {
        StopWatch casio = new StopWatch();

        System.out.printf("The starting time: %d%n", System.currentTimeMillis());

        casio.start(System.currentTimeMillis());
        System.out.printf("The current time at reset: %d%n", System.currentTimeMillis());

        long counter = 1;
        while (counter <= 100000000L) {
            counter++;
        }

        casio.stop(System.currentTimeMillis());
        System.out.printf("The current time at end: %d%n", System.currentTimeMillis());

        long elapsedTime = casio.getElapsedTime();

        System.out.printf("%nThe elapsed time for the stopwatch in milliseconds: %d", elapsedTime);


    }
}
