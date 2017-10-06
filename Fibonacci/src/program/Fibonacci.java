package program;

public class Fibonacci
{
	// should this be here or outside of the class (for one dictionary to rule them all)?
	int[] dictionary = new int[46];
	
	public Fibonacci()
	{
		dictionary[0] = 0;
		dictionary[1] = 1;
	}
	
	/**
	 * n = n-1 + n-2
	 * @param n the sequence number
	 * @return the fibonacci number
	 */
	public int fib(int n)
	{
		int ret = -1;
		int n2 = 1;
		int n3 = 0;
		
		if(n <0) return ret;
		if(n == 0) return n3;
		if(n == 1) return n2;
		for(int i = 1; i <= n; i++)
		{
			ret = n2 + n3;
			n2 = n3;
			n3 = ret;
		}
		
		return ret;
	}
	
	/**
	 * n = n-1 + n-2
	 * @param n the sequence number
	 * @return the fibonacci number
	 */
	
	public int recFib(int n)
	{
		// invalid condition
		if(n <0) return -1;
		if(n == 0) return dictionary[0];
		if(n == 1) return dictionary[1];
		int f = dictionary[n];
		
		if (f == 0)
		{
			// f not calculated (array values for int[] are 0 by default)
			f = recFib(n - 1) + recFib(n - 2);
			dictionary[n] = f;
		}
		return f;
	}
}
