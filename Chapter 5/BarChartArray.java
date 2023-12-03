import java.util.Scanner;
public class BarChartArray {
    public static void main (String[] args)   {  
        
        Scanner input = new Scanner (System.in);
        int[] nums = new int[5];
    
        for (int i = 0; i < 5; i++)
        { 
            System.out.printf("Enter a number: ");
            int num = input.nextInt();
            nums[i] = num;
        }

        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < nums[i]; j++) 
                System.out.printf("*");

            System.out.println();
        }
    }            
}