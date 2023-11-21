import java.util.Scanner;
public class CountingDifferentValues {
	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	
	System.out.print("Enter first number: ");
	int num1 = input.nextInt();

	System.out.print("Enter second number: ");
	int num2 = input.nextInt();

	System.out.print("Enter third number: ");
	int num3 = input.nextInt();

	System.out.print("Enter fourth number: ");
	int num4 = input.nextInt();

	System.out.print("Enter fifth number: ");
	int num5 = input.nextInt();		

	int positive = 0, negative = 0, zero = 0;

	if (num1 > 0) 
            positive++;
	else if (num1 < 0)
            negative++;        
	else
            zero++;

        if (num2 > 0)
            positive++;
        else if (num2 < 0) 
            negative++;
        else 
            zero++;
        
        if (num3 > 0) 
            positive++;
        else if (num3 < 0)
            negative++;
        else
            zero++;        

        if (num4 > 0)
            positive++;
        else if (num4 < 0)
            negative++;
        else
            zero++;        

        if (num5 > 0)
            positive++;
        else if (num5 < 0)
            negative++;
        else
            zero++;
        

	System.out.printf("%nThe number of positive numbers input: %d", positive);
	System.out.printf("%nThe number of negative numbers input: %d", negative);
	System.out.printf("%nThe number of zero numbers input: %d", zero);


	}
}