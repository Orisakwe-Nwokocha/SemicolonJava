public class StopWatchTest {

	public static void main(String[] args) {

	StopWatch casio = new StopWatch();
	
	System.out.printf("The starting time: %d%n", System.currentTimeMillis());

	casio.start();
	System.out.printf("The current time at reset: %d%n", casio.start());
	
	long counter = 1;
	while (counter <= 10000000L) {
		counter++;
	}

	casio.stop();
	System.out.printf("The current time at end: %d%n", casio.stop());

	long elapsedTime = casio.getElapsedTime();

	System.out.printf("%nThe elapsed time for the stopwatch in milliseconds: %d", elapsedTime);


   }

}