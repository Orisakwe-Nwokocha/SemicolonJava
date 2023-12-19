import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RunningTotalArrayTest {

	@Test
	public void testRunningTotal() {
		int[] arrayToCheck = {5, 10, 15, 20, 25};
		int[] runningSum = RunningTotalArray.runningTotal(arrayToCheck);
		int[] expectedOutput = {5, 15, 30, 50, 75};

		assertArrayEquals(expectedOutput, runningSum);
	}

}