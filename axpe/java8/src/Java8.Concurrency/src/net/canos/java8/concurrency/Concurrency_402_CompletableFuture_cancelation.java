package net.canos.java8.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author David Canós
 * Twitter @Canos
 */
public class Concurrency_402_CompletableFuture_cancelation {
	
	public static void main(String... args) throws InterruptedException, ExecutionException {
		log("START");
		Future<String> f = calculateAsyncWithCancellation();
		f.get();
		
    }
	
    
	public static Future<String> calculateAsyncWithCancellation() throws InterruptedException {
	    CompletableFuture<String> completableFuture = new CompletableFuture<>();
	    
	    Executors.newCachedThreadPool().submit(() -> {
	        Thread.sleep(2000);
	        completableFuture.cancel(false);
	        return null;
	    });
	 
	    return completableFuture;
	}
	
	private static void log(Object o) {
		System.out.println(Thread.currentThread().getName()+"\t"+o);
	}
}