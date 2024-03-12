import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MenstrualAppTest {
    private MenstrualApp cycleTracker;

    @BeforeEach
    public void setUp() {
        cycleTracker = new MenstrualApp("23/02/2024");
        cycleTracker.setAverageCycleLength(35);
    }

    @Test
    public void testThatIrregularMenstrualCyclesAreDetected(){

        assertThrows(IllegalArgumentException.class, ()-> cycleTracker.setAverageCycleLength(36));
        assertThrows(IllegalArgumentException.class, ()-> cycleTracker.setAverageCycleLength(20));

        assertThrows(IllegalArgumentException.class, ()-> cycleTracker.setMensesPhaseLength(2));
        assertThrows(IllegalArgumentException.class, ()-> cycleTracker.setMensesPhaseLength(8));
    }

    @Test
    public void testThatUserCanCalculateMenstrualCycle() {
        User user = cycleTracker.getUser();

        user.calculateMenstrualCycle(cycleTracker);

        assertEquals("15/03/2024", cycleTracker.getOvulationDate().toString());
        assertEquals("29/03/2024", cycleTracker.getNextPeriodStartDate().toString());
    }


}