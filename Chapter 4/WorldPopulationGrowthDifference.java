public class WorldPopulationGrowthDifference {
    public static void main (String [] args) {
      
        long POPULATION_CONSTANT = 8072783338L;
        long oldPopulation = 8072783338L;
        double growthRate = 0.88 / 100;
        int doubleYear = 0;
        int counter = 1;

        System.out.println("Year\t  Anticipated Population\tNumerical Increase");
        while (counter <= 75) {
            long newPopulation = (long) (oldPopulation * growthRate) + oldPopulation;
            long growthDifference = newPopulation - oldPopulation;
            oldPopulation = newPopulation;
            System.out.printf("%s%23d%24d%n", counter, newPopulation, growthDifference);

            counter++;

            boolean isDouble = newPopulation >= (POPULATION_CONSTANT * 2);
            if (isDouble && doubleYear == 0) doubleYear = counter;
        }

        if (doubleYear == 0) {
            System.out.printf("%nThe population would not be doubled within %d years", counter - 1);
        }

        else {
            System.out.printf("%nThe Year in which the population would be doubled is Year %d%n", doubleYear);
        }

    }

}