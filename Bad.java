import java.util.Scanner;
public class Bad {
	public static void main(String[] args) {

	Scanner input = new Scanner(System.in);
	
	int even = 0; 
	int odd = 0;
	
System.out.print("How many numbers (nElements) do you want to enter? ");
	int num = input.nextInt();
	
	int[] arr = new int[num];
		
	for(int i = 0; i < num; i++){
                System.out.println("Enter nElement " + (i+1) + ":");
                arr[i] = input.nextInt();
				
	}
		
		for (int i = 0; i < num; ++i) {
		if (num % 2 == 0) 
			even += arr[i];
			
			else 
			odd += arr[i];
		}
		
			
		

	int result = even + odd;
	System.out.println(even);
	System.out.println(odd);
	System.out.println(result);

	}
}