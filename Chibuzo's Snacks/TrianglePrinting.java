public class TrianglePrinting {
	public static void main(String[] args) {

	for (int i = 1; i <= 10; i++) { 
 	  	for (int a = 1; a <= i; a++) {
    			System.out.print("*");  			
  		}	

		for (int s = 1; s <= 13 - i; s++) {
			System.out.print(" ");
		}

		for (int b = 1; b <= 11 - i; b++) {
    			System.out.print("*"); 
  		}

		for (int s = 11 - i; s <= i + 11; s++) {
			System.out.print(" ");
		}

		for (int c = 1; c <= 11 - i; c++) {
    			System.out.print("*"); 
  		}
		
		for (int s = 1; s <= 13 - i; s++) {
			System.out.print(" ");
		}
	
		for (int d = 1; d <= i; d++) {
			System.out.print("*"); 
		}

		System.out.println();
	}

			
		
	} 
 }