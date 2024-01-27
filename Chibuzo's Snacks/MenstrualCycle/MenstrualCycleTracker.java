import java.util.Arrays;

public class MenstrualCycleTracker {
    private User user;
    private int previousPeriodDay;
    private int previousPeriodMonth;
    private int previousPeriodYear;
    private Date previousPeriodStartDate;
    private Date ovulationDay;
    private Date nextPeriodStartDate;
    private int mensesPhaseLength;
    private int averageCycleLength;

    public MenstrualCycleTracker(String lastPeriodDate) {
        user = new User(lastPeriodDate);

        setPeriodStartDate(user.getLastPeriodDate());
        previousPeriodStartDate = new Date(previousPeriodDay,previousPeriodMonth, previousPeriodYear);

        ovulationDay = new Date(previousPeriodDay, previousPeriodMonth, previousPeriodYear);
        nextPeriodStartDate = new Date(previousPeriodDay, previousPeriodMonth, previousPeriodYear);
    }

    public User getUser() {
        return user;
    }

    public Date getPreviousPeriodStartDate() {

        return previousPeriodStartDate;
    }

    private void setPeriodStartDate(String lastPeriodDate) {
        String[] dayMonthYear = lastPeriodDate.split("/");

        int day = Integer.parseInt(dayMonthYear[0]);
        int month = Integer.parseInt(dayMonthYear[1]);
        int year = Integer.parseInt(dayMonthYear[2]);

        previousPeriodDay = day;
        previousPeriodMonth = month;
        previousPeriodYear = year;
    }

    public void setMensesPhaseLength(int userMensesPhaseLength) {
        if (userMensesPhaseLength < 3 || userMensesPhaseLength > 5) {
            throw new IllegalArgumentException("Irregular menstrual cycle detected ===> Please consult a physician.");
        }
        mensesPhaseLength = userMensesPhaseLength;
    }

    public int getMensesPhaseLength() {
        return mensesPhaseLength;
    }

    public void setAverageCycleLength(int userAverageCycleLength) {
        if (userAverageCycleLength < 21 || userAverageCycleLength > 35) {
            throw new IllegalArgumentException("Irregular menstrual cycle detected ===> Please consult a physician.");
        }
        averageCycleLength = userAverageCycleLength;
    }

    public void calculateNextOvulationDay() {
        for (int count = 1; count <= averageCycleLength - 14; count++) {
            ovulationDay.nextDay();
        }
    }

    public Date getOvulationDay() {
        return ovulationDay;
    }

    public void calculateNextPeriodDay() {
        for (int count = 1; count <= averageCycleLength; count++) {
            nextPeriodStartDate.nextDay();
        }
    }

    public Date getNextPeriodStartDate() {
        return nextPeriodStartDate;
    }


}
