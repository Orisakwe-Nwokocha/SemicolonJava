import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MenstrualCycleTrackerTest {
    private MenstrualCycleTracker cycleTracker;

    @BeforeEach
    public void setUp() {
        cycleTracker = new MenstrualCycleTracker("27/01/2024");
        cycleTracker.setAverageCycleLength(28);
    }

    @Test
    public void testThatMenstrualCycleTrackerExists() {

        assertNotNull(cycleTracker);
    }

    @Test
    public void testThatMenstrualCycleTrackerUserExists() {
        User user = cycleTracker.getUser();

        assertNotNull(user);
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

        assertEquals("10/02/2024", cycleTracker.getOvulationDate().toString());
        assertEquals("24/02/2024", cycleTracker.getNextPeriodStartDate().toString());
    }


}