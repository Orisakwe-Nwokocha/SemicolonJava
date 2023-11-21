public class WorldPopulationGrowth {
    	public static void main (String [] args) {
      
        long population = 8072783338L;
        double growthRate = 0.88 / 100;


        double populationAfterOneYear = ((population * growthRate) + population);
        System.out.printf ("Population after one year: %.2f%n", populationAfterOneYear);

        double populationAfterTwoYears = ((populationAfterOneYear * growthRate) + populationAfterOneYear);
        System.out.printf ("Population after two years: %.2f%n", populationAfterTwoYears);

        double populationAfterThreeYears = ((populationAfterTwoYears * growthRate) + populationAfterTwoYears);
        System.out.printf ("Population after three years: %.2f%n", populationAfterThreeYears);

        double populationAfterFourYears = ((populationAfterThreeYears * growthRate) + populationAfterThreeYears);
        System.out.printf ("Population after four years: %.2f%n", populationAfterFourYears);

        double populationAfterFiveYears = ((populationAfterFourYears * growthRate) + populationAfterFourYears);
        System.out.printf ("Population after five years: %.2f%n", populationAfterFiveYears);

    }
}
