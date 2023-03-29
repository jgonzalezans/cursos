package net.canos.java8.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

/**
 * Ejemplo con Executors. No será necesario, pero hemos de conocer lo que no vamos a usasr, porque nuestro Legacy code es así.
 * 
 * @author David Canós
 * Twitter @Canos
 */
public class Concurrency_400_Future_Executor {
	
	
	
	public static void main(String... args) throws InterruptedException, ExecutionException {
		log("START");
		
		CompletableFuture<Integer> cf = generarBilletes();
		
		log("COSAS QUE PUEDO EJECUTAR MIENTRAS SE GENERAN LOS BILLETES");
		log("COSAS QUE PUEDO EJECUTAR MIENTRAS SE GENERAN LOS BILLETES");
		log("COSAS QUE PUEDO EJECUTAR MIENTRAS SE GENERAN LOS BILLETES");
		log("COSAS QUE PUEDO EJECUTAR MIENTRAS SE GENERAN LOS BILLETES");
		log("COSAS QUE PUEDO EJECUTAR MIENTRAS SE GENERAN LOS BILLETES");
		log("COSAS QUE PUEDO EJECUTAR MIENTRAS SE GENERAN LOS BILLETES");
		log("COSAS QUE PUEDO EJECUTAR MIENTRAS SE GENERAN LOS BILLETES");
		log("COSAS QUE PUEDO EJECUTAR MIENTRAS SE GENERAN LOS BILLETES");
		log("COSAS QUE PUEDO EJECUTAR MIENTRAS SE GENERAN LOS BILLETES");
		log("COSAS QUE PUEDO EJECUTAR MIENTRAS SE GENERAN LOS BILLETES");
		log("COSAS QUE PUEDO EJECUTAR MIENTRAS SE GENERAN LOS BILLETES");
		log("COSAS QUE PUEDO EJECUTAR MIENTRAS SE GENERAN LOS BILLETES");
		log("COSAS QUE PUEDO EJECUTAR MIENTRAS SE GENERAN LOS BILLETES");
		log("COSAS QUE PUEDO EJECUTAR MIENTRAS SE GENERAN LOS BILLETES");
		
		Integer idBillete = cf.get();
		log("FINAL:"+idBillete);
    }

    
	private static CompletableFuture<Integer> generarBilletes() {
		CompletableFuture<Integer> completableFuture = new CompletableFuture<>();
		 
	    Executors.newCachedThreadPool().submit(() -> {
	    	log("Generando billetes.....");
	        Thread.sleep(5000);
	        log("Billetes Generados");
	        completableFuture.complete(6666566);
	        return null; // OJO Que devuelve void
	    });
	    
	    log("COMPLETABLE FUTURO OBTENIDA");
	    
	    return completableFuture;
	    
	}
	
	private static void log(Object o) {
		System.out.println(Thread.currentThread().getName()+"\t"+o);
	}
}