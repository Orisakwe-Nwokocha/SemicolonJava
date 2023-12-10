import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest{
	@Test
	public void testThatCalculatorCanAddTwoPositiveNumbers(){
		Calculator calculator = new Calculator();
		int sum = calculator.add(5, 6);
		System.out.printf("Sum: %d%n", sum);
		assertEquals(11, sum);
	}

	@Test
	public void testThatCalculatorCanAddTwoNegativeNumbers(){
		Calculator calculator = new Calculator();
		int neg = calculator.add(-5, -6);
		System.out.printf("Neg: %d%n", neg);
		assertEquals(-11, neg);
	}

	@Test
	public void testZExponent(){
		Calculator calculator = new Calculator();
		int exp = calculator.exponent(2, 4);
		System.out.printf("Power: %d%n", exp);
		assertEquals(16, exp);
	}

	@Test
	public void testSquareRoot(){
		Calculator calculator = new Calculator();
		double root = calculator.sqrt(10000);
		System.out.printf("Root: %f%n", root);
		assertEquals(100.000000, root);
	}

}