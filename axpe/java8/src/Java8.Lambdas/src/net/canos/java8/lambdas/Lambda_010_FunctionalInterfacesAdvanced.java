package net.canos.java8.lambdas;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Vamos a estudiar Interfaces funcionales con las que ya hemos trabajado.
 * 
 * @author David Canós
 * Twitter @Canos
 */
public class Lambda_010_FunctionalInterfacesAdvanced {
	
	public static void main(String... args) {

		/*
		 * UPDATE 1. 
		 * Ahora que comprendemos Comparator, podemos jugar y hacer comparadores más complejos, más fácilmente
		 */
		List<Integer> fib = Arrays.asList(55,1,2,1,3,5,8,13,21,34,55);
		
		
		Comparator<Integer> comparacion = (Integer e1, Integer e2) -> {
			System.out.println(e1+" vs "+e2);
			if(e1.equals(13)) 
				return -1;
			else 
				return e1.compareTo(e2);
		};
		fib.sort(comparacion);	
		System.out.println("UPDATE 1");	
		System.out.println(fib);
		
		
		
		/*
		 * UPDATE 2. Puedo llevarme esta implementación a una clase diferente.
		fib.sort(MyIntegerComparator::compare);	
		System.out.println("\n\nUPDATE 2");	
		System.out.println(fib);
		 */
		
		
		/*
		 * UPDATE 3. Comprender el forEach
		*/
		fib.forEach((e) -> {
			// Error al ser consumer, debe devolver void
			return;
		});
		
		
		/*
		 * UPDATE 4. Otros sitios donde hemos usado lambdas históricamente
		
		System.out.println("\n\nUPDATE 4");	
		try {			
			CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e3) {
					e3.printStackTrace();
				}
				System.out.println("Future 1 terminada");
				return "future1";
			});
			
			System.out.println("Resultado:"+future1.get());

		} catch (InterruptedException | ExecutionException e3) { 
			e3.printStackTrace(); 
		}
		 */
    }


	
    interface MyIntegerComparator {
		static int compare(Integer e1, Integer e2) {
			if(e1.equals(34)) 
				return -1;
			else 
				return e1.compareTo(e2);
		}
    }
    
}