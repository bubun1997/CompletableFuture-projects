package com.soumya;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

class Helper{
	
	static void process() {
		
		for (int i = 1; i < 11 ; i++) {
			
			System.out.println(Thread.currentThread().getName()+" executing inside process");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(Thread.currentThread().getName()+" finished inside process");

		
	}
	
	static String accept(Void result) {
		
		System.out.println(Thread.currentThread().getName()+" executing inside accept");

		System.out.println(result);
		
		System.out.println(Thread.currentThread().getName()+" finished inside accept");
		
		return "OK";

	}
}
public class TestRunAysnc {

	
	public static void main(String[] args) throws InterruptedException, ExecutionException {

		CompletableFuture<Void> futureRunAsync = CompletableFuture.
		                                         runAsync(Helper::process);
		
		System.out.println("Main");
		
		futureRunAsync.get();
		
		System.out.println(futureRunAsync.complete(null));;
		
		//System.out.println("Main terminated");
			 
	   // System.out.println(Thread.currentThread().getName()+" executing....");
	   // Thread.sleep(2000);
		
	}

}
