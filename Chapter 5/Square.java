public class Square {
   public static void main(String... args){

	for (int i = 1; i <= 5; i++){
		System.out.print("*");	
	}

	System.out.println();

	for (int i = 1; i <= 3; i++){
		System.out.print("*");
		
		for (int s = 1; s <= 3; s++){
			System.out.print(" ");
		}	

		for (int j = 1; j <= 1; j++){
			System.out.print("*");
		}
		System.out.println();	
	}

	for (int i = 1; i <= 5; i++){
		System.out.print("*");	
	}
}


}