import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NewCalTest {
	
	@Test
	public void testNewCalCanSquare(){
		NewCal cal = new NewCal();
		
		int square = cal.square(8);

		System.out.printf("%n%d%n", square);

		assertEquals(64, cal.square(8));
		
	}

	@Test
	public void testCalCanReturnName(){
		NewCal cal = new NewCal();

		String name = "PHILLIP";

		String a = cal.nameA(name);

		System.out.printf("name: %s%n", a);

		assertEquals("you are from cohort 19", a);
	}



}