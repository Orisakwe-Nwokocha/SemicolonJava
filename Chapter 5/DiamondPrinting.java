public class DiamondPrinting {
	public static void main(String[] args) {
	
	for (int i = 1; i <= 5; i++){
		for (int s = 1; s <= 5 - i; s++) {
			System.out.print(" ");
		}
		for (int a = 1; a <= 2 * i - 1; a++) {
			System.out.print("*");
		}

		System.out.println();
	}

	for (int i = 4; i >= 1; i--){
		for (int s = 1; s <= 5- i; s++) {
			System.out.print(" ");
		}s
		for (int j = 1; j <= 2 * i - 1; j++) {
			System.out.print("*");
		}
		System.out.println();
	}


}
}