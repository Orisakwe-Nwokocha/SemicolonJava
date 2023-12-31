import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MBTIPersonalityTestFileTest {

    @Test
    public void getMBTIQuestions() {
        String actual = MBTIPersonalityTest.getMBTIQuestions(6);
        String expected = "A. candid, straight forward, frank\t\t\tB. tactful, kind encouraging";

        assertEquals(expected, actual);
    }
}