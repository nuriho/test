package program;

import static org.junit.Assert.*;

import org.junit.Test;

public class FibonacciTest
{

	
	@Test
	public void fibTest()
	{
		Fibonacci cot = new Fibonacci();
		
		int n = -1;
		int expected = -1;
		String comment = "Sequence: " + n;
		assertEquals(comment, expected, cot.fib(n));
		
		n = 0;
		expected = 0;
		comment = "Sequence: " + n;
		assertEquals(comment, expected, cot.fib(n));
		
		n = 1;
		expected = 1;
		comment = "Sequence: " + n;
		assertEquals(comment, expected, cot.fib(n));
		
		n = 2;
		expected = 1;
		comment = "Sequence: " + n;
		assertEquals(comment, expected, cot.fib(n));
		
		n = 5;
		expected = 5;
		comment = "Sequence: " + n;
		assertEquals(comment, expected, cot.fib(n));
		
		n = 9;
		expected = 34;
		comment = "Sequence: " + n;
		assertEquals(comment, expected, cot.fib(n));
		
		n = 15;
		expected = 610;
		comment = "Sequence: " + n;
		assertEquals(comment, expected, cot.fib(n));
		
		n = 45;
		expected = 1134903170;
		comment = "Sequence: " + n;
		assertEquals(comment, expected, cot.fib(n));
		
//		n = 50;
//		expected = 12586269025;
//		comment = "Sequence: " + n;
//		assertEquals(comment, expected, cot.fib(n));
	}
	
	@Test
	public void recFibTest()
	{
		Fibonacci cot = new Fibonacci();
		
		int n = -1;
		int expected = -1;
		String comment = "Sequence: " + n;
		assertEquals(comment, expected, cot.recFib(n));
		
		n = 0;
		expected = 0;
		comment = "Sequence: " + n;
		assertEquals(comment, expected, cot.recFib(n));
		
		n = 1;
		expected = 1;
		comment = "Sequence: " + n;
		assertEquals(comment, expected, cot.recFib(n));
		
		n = 2;
		expected = 1;
		comment = "Sequence: " + n;
		assertEquals(comment, expected, cot.recFib(n));
		
		n = 5;
		expected = 5;
		comment = "Sequence: " + n;
		assertEquals(comment, expected, cot.recFib(n));
		
		n = 9;
		expected = 34;
		comment = "Sequence: " + n;
		assertEquals(comment, expected, cot.recFib(n));
		
		n = 15;
		expected = 610;
		comment = "Sequence: " + n;
		assertEquals(comment, expected, cot.recFib(n));
		
		n = 45;
		expected = 1134903170;
		comment = "Sequence: " + n;
		assertEquals(comment, expected, cot.recFib(n));
		
//		n = 50;
//		expected = 12586269025;
//		comment = "Sequence: " + n;
//		assertEquals(comment, expected, cot.recFib(n));
	}

}
