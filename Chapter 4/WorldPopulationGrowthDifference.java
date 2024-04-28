public class WorldPopulationGrowthDifference {
    public static void main(String[] args) {
        final long INITIAL_POPULATION = 8072783338L;
        long oldPopulation = INITIAL_POPULATION;
        final double GROWTH_RATE = 0.88 / 100;
        int doubleYear = 0;
        int yearCounter = 1;

        System.out.println("Year\t   Anticipated Population\t    Numerical Increase");
        
        while (yearCounter <= 75) {
            long newPopulation = (long) (oldPopulation * GROWTH_RATE) + oldPopulation;
            long growthDifference = newPopulation - oldPopulation;
            oldPopulation = newPopulation;
            System.out.printf("%d\t%,23d\t    %,24d%n", yearCounter, newPopulation, growthDifference);

            boolean isDouble = newPopulation >= (INITIAL_POPULATION * 2);
            if (isDouble && doubleYear == 0) doubleYear = yearCounter;

            yearCounter++;
        }

        if (doubleYear == 0) {
            System.out.printf("%nPopulation would not be doubled within %d years%n", yearCounter - 1);
        } else {
            System.out.printf("%nThe population would be doubled in Year %d%n", doubleYear);
        }
    }
}
