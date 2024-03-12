import java.util.Scanner;

public class MenstrualAppMain {
    private static MenstrualApp cycleTracker;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        startApp();
    }

    private static void displayUserResult() {
        User user = cycleTracker.getUser();
        user.calculateMenstrualCycle(cycleTracker);

        Date ovulationDay = cycleTracker.getOvulationDate();
        displayDate("\nYour next ovulation date: ", ovulationDay);

        Date nextPeriodStartDate = cycleTracker.getNextPeriodStartDate();
        displayDate("Your next period start date: ", nextPeriodStartDate);

        System.out.printf("""
                                            
                        Fertile window:
                            Your next most fertile time is 5 days before your ovulation date and a day after your ovulation date
                            Your next least fertile time (safe period) is 2 days before your next period start date and
                            during your %s days of menstruation
                            """, cycleTracker.getMensesPhaseLength());

        print("""
                            
                Note: This period tracker is only an estimation. Your unique menstrual cycle
                may vary from these results.""");
    }

    private static void setCycleLength() {
        String averageCycleLength = input("What is your usual cycle length?:");
        if (isInvalidData(averageCycleLength)) {
            print("Invalid data. Please try again.");
            setCycleLength();
        }

        try {
            cycleTracker.setAverageCycleLength(Integer.parseInt(averageCycleLength));
        }
        catch (RuntimeException e) {
            print(e.getMessage());
        }

        displayUserResult();
    }

    private static void setMensesLength() {
        String mensesPhaseLength = input("How many days does your period usually last:");
        try {
            cycleTracker.setMensesPhaseLength(Integer.parseInt(mensesPhaseLength));
        }
        catch (RuntimeException e) {
            print("Invalid data. Please try again.");
            setMensesLength();
        }

        setCycleLength();
    }

    private static void startApp() {
        String lastPeriodDate = input("What date did your last period start? (dd/mm/yyyy):");

        if (!isValid(lastPeriodDate)) {
            print("Invalid date format. Please enter a valid date.\n");
            startApp();
        }

        validateDate(lastPeriodDate);

        cycleTracker = new MenstrualApp(lastPeriodDate);

        setMensesLength();
    }

    private static void validateDate(String lastPeriodDate) {
        String[] lastPeriodDateSplit = lastPeriodDate.split("/");

        boolean isDayIncorrect = lastPeriodDateSplit[0].length() != 2;
        boolean isMonthIncorrect = lastPeriodDateSplit[1].length() != 2;
        boolean isYearIncorrect = lastPeriodDateSplit[2].length() != 4;

        if (isDayIncorrect || isMonthIncorrect || isYearIncorrect) {
            print("Invalid date format. Please enter a valid date.\n");
            startApp();
        }
    }

    private static void print(String prompt) {
        System.out.println(prompt);
    }

    private static boolean isValid(String s) {
        char[] chars = s.toCharArray();
        int count = 0;
        for (char c : chars) if (c == '/') count++;

        return count == 2;
    }

    private static void displayDate(String header, Date date) {
        System.out.printf("%s%s%n", header, date);
    }

    private static boolean isInvalidData(String data){
        for(int index = 0; index < data.length(); index++){
            int digit = data.charAt(index) - '0';
            if (digit < 0 || digit> 9) return true;
        }

        return false;
    }

    private static String input(String prompt) {
        print(prompt);

        return scanner.nextLine();
    }
}
