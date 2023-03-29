package net.canos.java8.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

/**
 * @author David Canós
 * Twitter @Canos
 */
public class Concurrency_401_CompletableFuture_statics {
	
	public static void main(String... args) throws InterruptedException, ExecutionException {
		log("START");
		
		// RespuestaUsuarioResponse rellenado
		Executor executor = new ForkJoinPool(5);
		CompletableFuture<String> tarea1_y_2 = CompletableFuture.supplyAsync(() -> {
			// tarea 1
			return 1;
		}, executor).thenApplyAsync((x) -> {
			// tarea 2
			return "";
		});
		
		CompletableFuture<Void> rVoid = CompletableFuture.runAsync(() -> {
			 // tarea3
		});
		
	
		
		
		/*
		 * UPDATE 1. supplyAsync 
		 * Mucho más limpio que el ejercicio anterior.
		 * Supplier permite devolver un valor.
		
		CompletableFuture.supplyAsync(() -> {
	    	log("Dentro del Thread");
			return "Hola Mundo";
		}).thenAcceptAsync((x) -> {
			
			CompletableFuture.runAsync(() -> {
				log("Dentro del Thread en runAsync");	
			});
			
			CompletableFuture.runAsync(() -> {
				log("Dentro del Thread en runAsync");
			});
		});
		 */
		
		// llamo al proceso interno
//		CompletableFuture.runAsync(() -> {
//			log("Dentro del Thread en runAsync");
//		});
		
		/*
		 * UPDATE 2. runAsync 
		 * Runnable no devuelve nada, void.
		 */
		
		
		//return respuestaUsuarioResponse;
		
		/*
		 * UPDATE 3
		 */
		CompletableFuture.runAsync(() -> {
			log("Dentro del Thread indicado por mi");
		}, Executors.newCachedThreadPool());
		
		
		/*
		 * UPDATE 3
		 */
		CompletableFuture<String> cf2 = CompletableFuture.completedFuture("Hola");
		String f2 = cf2.get();
		
		/*
		 * UPDATE 4. allOf
		 */
		CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "David");
		CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "Juan");
		CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> "Martina");
		
		CompletableFuture<Void> combinedFuture  = CompletableFuture.allOf(future1, future2, future3);
		 
		combinedFuture.get();
		
		log("UPDATE 4: "+future1.isDone()+" "+future2.isDone()+" "+future3.isDone());
		
		
		log("END");		
    }

	
	private static void log(Object o) {
		System.out.println(Thread.currentThread().getName()+"\t"+o);
	}
}