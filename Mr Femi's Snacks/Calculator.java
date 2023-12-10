public class Calculator{
     
	public int add(int num1, int num2){
		return num1 + num2;
	}

	public int exponent(int num1, int num2){
		int result = 1;
		for (int i = 1; i <= num2; i++){
			result *= num1;
		}
		return result;
	}

	public double sqrt(double num){
		double result = Math.pow(num, 0.5);
		return result;
	}


}