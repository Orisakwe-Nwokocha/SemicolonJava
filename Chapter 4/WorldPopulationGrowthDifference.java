public class WorldPopulationGrowthDifference {
    	public static void main (String [] args) {
      
     long population = 8072783338L;
     double growthRate = 0.88 / 100;
     long oldPopulation = 8072783338L;
     long oldPopulationConstant = 8072783338L;
     long growthDifference;
     int doubleYear = 0;
	int counter = 1; 
	int count = 1;
	
	System.out.println("Year\t  Anticipated Population\tNumerical Increase");
	
	while (counter <= 75) {
	 	population += (population * growthRate);
	 	growthDifference = population - oldPopulation;
	 	oldPopulation+= (oldPopulation * growthRate);
	 	System.out.printf("%s\t\t%d\t\t   %d%n","Year " + counter, population,growthDifference);
		
		counter++;
	
		if (population >= (oldPopulationConstant * 2)) {
			while (count > 0) {
				doubleYear = counter;
				count--;
			}
		}
	} 
	
	if (doubleYear <= 0) {
		System.out.printf("%nThe population would not be double the current year within %d years", counter - 1);
	}
	
	else {
		System.out.printf("%nThe Year in which the population would be double the current year is Year %d%n", doubleYear);
	}
	
		// Boolean isDouble = true;
	//	isDouble = false;	
	
	
	}


}