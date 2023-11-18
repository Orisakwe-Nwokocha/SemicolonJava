import java.util.Scanner;

public class Product {

	public static void main(String[] args) {
 	Scanner input = new Scanner(System.in);
	
	System.out.print("How many numbers (nElements) do you want to enter? ");
	int num = input.nextInt();
	
	int[] arr = new int[num];
	int product = 1;
	
	for(int i = 0; i < num; i++){
                System.out.println("Enter element " + (i+1));
                arr[i] = input.nextInt();
	}
		for (int i = 0; i < num; ++i) {
		product *= arr[i];
		
}
	

System.out.println(product);


 	/* System.out.print("Enter first integer: ");  
		int x = input.nextInt();

	System.out.print("Enter second integer: ");  
		int y = input.nextInt();

	System.out.print("Enter third integer: ");  
		int z = input.nextInt();


 	int result = x * y * z;
		System.out.printf("Product is %d%n", result); */
 
 	
 } 
}

