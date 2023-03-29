package net.canos.java8.lambdas;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 
 * 
 * @author David Canós
 * Twitter @Canos
 */
public class Lambda_009_Callable {
	
	@SuppressWarnings("unused")
	public static void main(String... args) throws Exception {

		log("Comienza la fiesta");
		/*
		 * UPDATE 1. Callable Java8 vs Java 7 
		 */
		Callable<Integer> callableObjJava8 = () -> {
			log("DENTRO DEL CALLABLE");
			//Thread.sleep(10);
			return 69*127;
		};

		/*
		 * Java 7
		 */
		Callable<Integer> callableObjPreJava8 = new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				log("DENTRO DEL CALLABLE");
				//Thread.sleep(10);
				return 69*127;
			}
		};
		
		
		// NEWIE
		ExecutorService service =  Executors.newSingleThreadExecutor();
		// Java 7
		Future<Integer> future = service.submit(callableObjPreJava8);
		// Java 8
		//Future<Integer> future = service.submit(callableObjJava8);
		
		log("INSTRUCCIONES NO BLOQUEADAS");
		log("INSTRUCCIONES NO BLOQUEADAS");
		/* 
		 * Fuerzo un delay de 100ms para que se vea claramente que la ejecución, 
		 * no solo es multi-hilo si no que ademas es concurrente
		 */
		Thread.sleep(100);
		log("INSTRUCCIONES NO BLOQUEADAS");
		log("INSTRUCCIONES NO BLOQUEADAS");
		log("INSTRUCCIONES NO BLOQUEADAS");

		Integer result = future.get();
		
		log("RESULT:"+result);
		
		// OLDIE sintax
		//int r = callableObjJava8.call();		
    }
	
	private static void log(Object o) {
		System.out.println(Thread.currentThread().getName()+" "+o);
	}
}