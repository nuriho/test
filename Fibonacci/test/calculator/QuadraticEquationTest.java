package calculator;

import org.junit.Assert;
import org.junit.Test;

public class QuadraticEquationTest
{

	@Test
	public void testSolve()
	{
		double a = 1;
		double b = 4;
		double c = 4;
		double expectedPositive = -2;
		double expectedNegative = -2;
		double[] x = QuadraticEquation.solve(a, b, c);
		Assert.assertEquals("failed", expectedPositive, x[0], 0.1);
		Assert.assertEquals("failed", expectedNegative, x[1], 0.1);

		a = 5;
		b = 4;
		c = -3;
		expectedPositive = 0.47;
		expectedNegative = -1.27;
		x = QuadraticEquation.solve(a, b, c);
		Assert.assertEquals("failed", expectedPositive, x[0], 0.1);
		Assert.assertEquals("failed", expectedNegative, x[1], 0.1);
	}

}
