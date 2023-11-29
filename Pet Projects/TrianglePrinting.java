public class TrianglePrinting {
	public static void main(String[] args) {

	for (int i = 1; i <= 10; i++) { 
 	  	for (int j = 0; j < i; j++) {
    			System.out.print ("*");  			
  		}	
		System.out.println();
	}
		
	System.out.println();
		
	for (int a = 10; a >= 1; a--) { 
 	  	for (int b = 0; b < a; b++) {
    			System.out.print ("*"); 
  		}	
		System.out.println();
	}		

	System.out.println();
			
	for (int c = 10; c >= 1; c--) { 
	System.out.print (" ");
 	  	for (int d = 0; d < c; d++) {
    			System.out.print ("*"); 
  		}	
  		
		System.out.println();
		
	}
	
	System.out.println();
	
	for (int e = 0; e <= 10; e++) { 
		System.out.print (" ");
 	  	for (int f = 0; f < e; f++) {
    			System.out.print ("*"); 
  		}	
		System.out.println();
	}
		
	
			
		
	} 
 }