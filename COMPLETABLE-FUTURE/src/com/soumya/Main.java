package com.soumya;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {

		ExecutorService service = Executors.newFixedThreadPool(5);
		
		service.submit(() -> process());
		
		for (int i = 1; i < 11; i++) {
			
			System.out.println(Thread.currentThread().getName()+" executing...");
		}
		
		System.out.println(Thread.currentThread().getName()+" finished ");

		service.shutdown();
	}

	private static void process() {
		
		for (int i = 1; i < 11; i++) {
			
			System.out.println(Thread.currentThread().getName()+" executing...");
		
		}
		
		System.out.println(Thread.currentThread().getName()+" finished ");
		
	}

}
