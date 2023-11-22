public class WorldPopulationGrowthLong {
    	public static void main (String [] args) {
      
        long population = 8072783338L;
        double growthRate = 0.88 / 100;

        long populationAfterOneYear = (long) ((population * growthRate) +  population);
        System.out.printf ("Population after one year: %d%n", populationAfterOneYear);

        long populationAfterTwoYears = (long) ((populationAfterOneYear * growthRate) + populationAfterOneYear);
        System.out.printf ("Population after two years: %d%n", populationAfterTwoYears);

        long populationAfterThreeYears = (long) ((populationAfterTwoYears * growthRate) + populationAfterTwoYears);
        System.out.printf ("Population after three years: %d%n", populationAfterThreeYears);

        long populationAfterFourYears = (long) ((populationAfterThreeYears * growthRate) + populationAfterThreeYears);
        System.out.printf ("Population after four years: %d%n", populationAfterFourYears);

        long populationAfterFiveYears = (long) ((populationAfterFourYears * growthRate) + populationAfterFourYears);
        System.out.printf ("Population after five years: %d%n", populationAfterFiveYears);

    }
}
