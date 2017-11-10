package calculator;

public class QuadraticEquation
{	
	public static double[] solve(double a, double b, double c)
	{
		double[] x = new double[2];
		
		x[0] = solvePositive(a,b,c);
		x[1] = solveNegative(a,b,c);
		
		return x;
	}

	private static double solvePositive(double a, double b, double c)
	{
		// x = (-b + sqrt(b^2 - 4ac) ) / 2a
		double sqrt = getSqrt(a,b,c);
		double x = ((-b + sqrt) / (2*a));
		return x;
	}

	private static double solveNegative(double a, double b, double c)
	{
		// x = (-b - sqrt(b^2 - 4ac) ) / 2a
		double sqrt = getSqrt(a,b,c);
		double x = ((-b - sqrt) / (2*a));
		return x;
	}

	private static double getSqrt(double a, double b, double c)
	{
		double sqrt = Math.sqrt( ((b*b) - (4*a*c)));
		return sqrt;
	}
}
