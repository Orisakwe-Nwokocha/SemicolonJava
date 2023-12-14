import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ListOfDigitsArrayTest{

	@Test
	public void testGetDigitsArray(){
		ListOfDigitsArray listOfDigitsArray = new ListOfDigitsArray();
		
		int number = 541;
		int[] returnedArray = listOfDigitsArray.getDigitsArray(number);
		int[] expected = {5, 4, 1};

		assertArrayEquals(expected, returnedArray);
	}


}