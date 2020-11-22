package com.assignment.test;

import com.assignment.prime.PrimeFinder.PrimeNumber;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class PrimeTest {
	
	@Test
	public void testRandomPrimeNumbers() {
		//<0
		assertFalse(PrimeNumber.isPrimeNumber(-90));
		
		//near 0
		assertFalse(PrimeNumber.isPrimeNumber(0));
		assertFalse(PrimeNumber.isPrimeNumber(1));
		assertTrue(PrimeNumber.isPrimeNumber(2));
		
		//random
		assertTrue(PrimeNumber.isPrimeNumber(47));
		assertFalse(PrimeNumber.isPrimeNumber(27));
		
	}

	
}
