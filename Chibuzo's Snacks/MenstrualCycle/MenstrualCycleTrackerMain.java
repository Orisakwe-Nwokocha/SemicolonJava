import java.util.Scanner;

public class MenstrualCycleTrackerMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("What day did you your last period start? format ==> (dd/mm/yyyy)");
        String lastPeriodDate = input.nextLine();

        MenstrualCycleTracker cycleTracker = new MenstrualCycleTracker(lastPeriodDate);

        System.out.println("\nHow long does your period usually last?");
        int mensesPhaseLength = input.nextInt();

        try {
            cycleTracker.setMensesPhaseLength(mensesPhaseLength);

            try {
                System.out.println("\nNumber of days in your cycle?");
                int averageCycleLength = input.nextInt();

                cycleTracker.setAverageCycleLength(averageCycleLength);

                User user = cycleTracker.getUser();

                System.out.println("\nHow many months cycle do you want to see?");
                input.nextLine();
                String userChoice = input.nextLine();
                int cycleMonths = 0;

                if (!isValidData(userChoice)) {
                    System.out.println("Invalid input. Here is your menstrual cycle info for the next month");
                    cycleMonths = 1;

                } else cycleMonths = Integer.parseInt(userChoice);

                for (int count = 0; count < cycleMonths; count++) {
                    user.calculateMenstrualCycle(cycleTracker);

                    System.out.println();

                    Date ovulationDay = cycleTracker.getOvulationDate();
                    displayDate("Your next ovulation date: ", ovulationDay);

                    Date nextPeriodStartDate = cycleTracker.getNextPeriodStartDate();
                    displayDate("Your next period start date: ", nextPeriodStartDate);

                    System.out.printf("""
                                                
                            Fertile window:
                                Your next most fertile time is 5 days before ovulation %s and a day after ovulation %s
                                Your next least fertile time (safe period) is 2 days before your next period start date %s
                                and during the %d days of menstruation
                            """, ovulationDay, ovulationDay, nextPeriodStartDate, cycleTracker.getMensesPhaseLength());

                }

                System.out.println("""
                                                    
                            Note: This period tracker is only an estimation. Your unique menstrual cycle
                            may vary from these results.
                            """);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    private static void displayDate(String header, Date date) {
        System.out.printf("%s%s%n", header, date);
    }

    private static boolean isValidData(String data){
        for(int index = 0; index < data.length(); index++){
            int digit = data.charAt(index) - '0';
            if (digit < 0 || digit> 9) return false;
        }

        return true;
    }
}
