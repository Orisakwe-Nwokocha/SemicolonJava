import java.util.Scanner;
public class Large {
	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	
	System.out.print("How many numbers (nElements) do you want to enter? ");
	int num = input.nextInt();
	

	int[] arr = new int[num];

	
	for(int i = 0; i < num; i++){
                System.out.println("Enter nElement " + (i+1) + ":");
                arr[i] = input.nextInt();
	}
	
	int smallest = arr[0];
	int largest = arr[0];

	for (int i = 0; i < arr.length; i++) {
		
		if (arr[i] < smallest)
			smallest = arr[i];	
		else if (arr[i] > largest) {
			largest = arr[i];			
		}			
	}
	
	
	System.out.println(smallest + " is the smallest number");
        System.out.println(largest + " is the largest number");


	}
}