public class User {
    private String lastPeriodDate;

    public User(String lastPeriodDate) {
        this.lastPeriodDate = lastPeriodDate;
    }
    public String getLastPeriodDate() {
        return lastPeriodDate;
    }

    public void calculateMenstrualCycle(MenstrualCycleTracker cycleTracker) {
        getNextOvulationDay(cycleTracker);
        getNextPeriodDay(cycleTracker);
    }

    private void getNextOvulationDay(MenstrualCycleTracker cycleTracker) {
        cycleTracker.calculateNextOvulationDate();
    }

    private void getNextPeriodDay(MenstrualCycleTracker cycleTracker) {
        cycleTracker.calculateNextPeriodDate();
    }
}
