package net.canos.java8.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author David Canós
 * Twitter @Canos
 */
public class Concurrency_404_CompletableFuture_combinacion_compose {
	
	public static void main(String... args) throws InterruptedException, ExecutionException {
	
		/* 
		 * UPDATE 1. thenCompose permite concatenar CompletableFuture
		 */
		CompletableFuture<String> f = CompletableFuture.supplyAsync(() -> "1")
			.thenCompose((x) -> CompletableFuture.supplyAsync(() -> x+"2"));
		
		log("UPDATE 1:"+f.get());
		
		/*
		 * UPDATE 2 
		 * ¿Qué diferencia lo anterior con esta estructura?
		 */
		CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> "3");
		f2.thenCompose((x) -> CompletableFuture.supplyAsync(() -> x+"4"));
		
		log("UPDATE 2:"+f2.get());
		
		
		/*
		 * UPDATE 3. thenCombine
		 */
		CompletableFuture<String> s = f.thenCombine(f2, (x,y) -> x+y);
		log("UPDATE 3:"+s.get());
		
		/*
		 * UPDATE 4. thenAcceptBoth
		 * Devuelve CompletableFuture<Void>
		 */
		f.thenAcceptBothAsync(s, (x,y) -> log("UPDATE 4:"+x+y));
		
    }
	
	
	private static void log(Object o) {
		System.out.println(Thread.currentThread().getName()+"\t"+o);
	}
}