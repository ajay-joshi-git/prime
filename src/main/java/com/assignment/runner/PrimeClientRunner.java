package com.assignment.runner;

import com.assignment.prime.PrimeFinder;

/**
 * Execute Prime/Client 
 */
public class PrimeClientRunner {
	private static final int SERVER_PORT = 16000;

	public static void main(String[] args) {
		System.out.println("Starting Prime...");
		new PrimeFinder(SERVER_PORT).executePrime();
		
	}
}
