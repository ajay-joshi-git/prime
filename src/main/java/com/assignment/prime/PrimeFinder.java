package com.assignment.prime;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.stream.IntStream;

import com.assignment.client.Client;

/*
 * Extends Client socket and implement prime Client
 * check if number from randomizer/server is prime or not   
 */
public class PrimeFinder extends Client {
	
	public PrimeFinder(int serverPortNumber) {
		super(serverPortNumber);
	}

	public static class PrimeNumber {

		public static boolean isPrimeNumber(int number) {
			if(number <= 2)
		        return number == 2;
		    else
		        return  (number % 2) != 0
		                &&
		                IntStream.rangeClosed(3, (int) Math.sqrt(number))
		                .filter(n -> n % 2 != 0)
		                .noneMatch(n -> (number % n == 0));
		}
	}
	
	//Prime Process - read , check and write result
	@Override
	public void processData(DataInputStream in, DataOutputStream out) throws InterruptedException {
		try {
			int inNumber = in.readInt();
			
			//is Prime?
            System.out.println("Randomizer sent number [" + inNumber + "]");
			boolean isPrime = PrimeNumber.isPrimeNumber(inNumber);
			
			//Write data to socket
			out.writeInt(inNumber);
			out.writeBoolean(isPrime);
			
		} catch (IOException e) {
			throw new RuntimeException(e);
		}		
	}
	
}
