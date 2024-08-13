package com.soumya;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.IntStream;

public class TestSupplyAsync {

	static int calculateSum() {
		
		System.out.println(Thread.currentThread().getName()+" processing...");
		
		return IntStream.of(3,6,7,12,9,18,4).
			   parallel().
			   map(num -> { 
				   
				   System.out.println(Thread.currentThread().getName()+" inside map...");
				   Sleep(4000);
				   return num*2;
				   
			   }).
			   sum();
		
	}
	
	static void Sleep(long duration) {
		
	    System.out.println(Thread.currentThread().getName()+" sleeping");

		try {
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		
	

		CompletableFuture<Integer> future = CompletableFuture.
											supplyAsync(() -> calculateSum());
		
		
		
		Integer value = future.get();
		System.out.println(value);
		future.complete(66);
		System.out.println(future.complete(2));;
		System.out.println(value);
	}
	
}
