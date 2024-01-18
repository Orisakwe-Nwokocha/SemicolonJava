public class ProductOfTwoIntegers {
    public static void main(String[] args) {
    	productOfTwoIntegers(4, 5);
    }

    public static void productOfTwoIntegers(int number1, int number2) {
	int product = 0;

	int condition1 = number1;
	int condition2 = number2;
	
	if (condition1 < 0 && condition2 < 0) {
		number1 *= -1;
		number2 *= -1;
	}
	else if (condition1 < 0) number1 *= -1;
	else if (condition2 < 0) number2 *= -1;

	for (int count = 1; count <= number2; count++) {
		product += number1;
    }
	if (condition1 < 0 && condition2 < 0) System.out.printf("The product of -%d and -%d is: %d", number1, number2, product);
	else if (condition1 < 0) System.out.printf("The product of -%d and %d is: -%d", number1, number2, product);
    	else if (condition2 < 0) System.out.printf("The product of %d and -%d is: -%d", number1, number2, product);
	else System.out.printf("The product of %d and %d is: %d", number1, number2, product);
	
    }

}
