package com.soumya.thenasync;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.IntStream;

class Buffer{
	
	static IntStream getIntStream() {
		
		return IntStream.
			   of(new int[] {
					   3,5,6,2,12,28,26,15,7,8,Integer.valueOf("70"),
					   6,0,123,45,56
			   });
	}
}
public class Test1 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
         
	CompletableFuture<Void>	 future = CompletableFuture.
									  supplyAsync(() -> Buffer.getIntStream()).
									  thenApply(intStream ->{ 
										       System.out.println(Thread.currentThread().getName()+" executing in 1st apply...");
										       
										       return intStream.filter(num -> num>25);
										  }).
									  thenApply(intStream ->{ 
									           System.out.println(Thread.currentThread().getName()+" executing in 2nd apply...");
									           
									           try {
													Thread.sleep(3000);
												} catch (InterruptedException e) {
													e.printStackTrace();
												}
										       return intStream.map(num -> num*2);
										  }).
									  thenAccept(intStream -> {
									         System.out.println(Thread.currentThread().getName()+" executing in accept...");
										     System.out.println(intStream.sum());
										  });
									
	
	    
	    Void v = future.get();
	   System.out.println( future.complete(null));
	    System.out.println(v);
	    
	    System.out.println(Thread.currentThread().getName()+" finished...");
	}

}
