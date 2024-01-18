public class AdvancedMultiplicationTable {
    public static void main(String[] args) {

	for (int count = 1; count <= 12; count++) {
		for (int multiply = 1; multiply <= 12; multiply++) {
			System.out.printf("%d * %2d  =  %2d\t", multiply, count, (multiply * count));
			
		}
		System.out.println();
	} 
	
    }
}
