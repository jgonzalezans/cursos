package net.canos.java8.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author David Canós
 * Twitter @Canos
 */
public class Concurrency_403_CompletableFuture_combinacion_then {
	
	public static void main(String... args) throws InterruptedException, ExecutionException {
	
		/* 
		 * UPDATE 1. CompletableFuture thenRun
		 * OJO se ejecuta antes que haya completado la original.
		 */
		CompletableFuture<String> f = CompletableFuture.supplyAsync(() -> "hola");
		
		f.thenRun(() -> log("thenRun"));
		
		f.thenAccept((x) -> log("thenAccept:"+x));
		
		f.thenApply((x) -> {
			log("thenApply:"+x);
			return "ja";
		});
		
		log(f.get());
		
    }
	
	
	private static void log(Object o) {
		System.out.println(Thread.currentThread().getName()+"\t"+o);
	}
}