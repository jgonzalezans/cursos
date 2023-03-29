package net.canos.java8.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 
 * @author David Canós
 * Twitter @Canos
 */
public class Concurrency_402_CompletableFuture {
	
	public static void main(String... args) {
		
	
		/*
		 * UPDATE 4. Otros sitios donde hemos usado lambdas históricamente
		 */
		CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(1000);
				System.out.println("Future 1 terminada");
			} catch (InterruptedException e3) {
				e3.printStackTrace();
			}
			return "future1";
		});
		CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(5000);
				System.out.println("Future 2 terminada");
			} catch (InterruptedException e3) {
				e3.printStackTrace();
			}
			return "future2";
		});
		
		future1.thenApply((r) -> {
			System.out.println("resultado future 1:"+r);
			return null;
		});
		
		future2.thenApply((r) -> {
			System.out.println("resultado future 2:"+r);
			return null;
		});
		
		try {
			future1.get();
		} catch (InterruptedException | ExecutionException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
    }

    
}