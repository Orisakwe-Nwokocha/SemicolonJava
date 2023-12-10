import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GeoLocatorTest{
	@Test
	public void testGeopolitical(){
		GeoLocator geoLocator = new GeoLocator();

		String state = "kano";

		String zone = geoLocator.findGeo(state);

		System.out.printf("Zone: %s%n", zone);

		assertEquals("You are from the North West", zone);
	}

}