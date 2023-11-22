public class ClockTest {
	public static void main(String[] args) {
		
	Clock casio = new Clock(13, 37, 50);
	Clock quartz = new Clock(24, 60, 89);

	String timeCasio = casio.displayTime();
	String timeQuartz = quartz.displayTime();

	System.out.printf("%n%s%n%s", timeCasio, timeQuartz);


	}
}