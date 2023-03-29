package net.canos.java8.optionals;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Un pequeño ejemplo de un hola mundo desde lambdas
 * 
 * @author David Canos 
 * Twitter: @Canos
 *
 */
public class Optionals_000_Introduccion {
	
	public static void main(String[] args) {
		
		/*
		 * UPDATE 1. Creation
		 */
		Optional<String> string2 = Optional.empty();
		Optional<String> string = Optional.of("hola");
		Optional<String> stringNull = Optional.ofNullable("");
		
		/*
		 * UPDATE 2.  
		 */
		Integer valor = Stream.<Integer>of(1).findFirst().orElse(-1);
				
		// INICIALIZAR DE MANERA SEGURA UNA VARIABLE
		//Integer valor3 = Optional.of(page).orElse(0);
		
		log(valor);
		
		if(!false) return;
		
		if(string.isPresent()) 
			string.get();
		
		log(string.orElse(""));
		
		
		/*
		 * UPDATE 2. 
		 */
		Optional<String> value1 = Optional.ofNullable("Valor");
		log(value1.orElse("No hay valor"));
		
		
		/*
		 * UPDATE 3
		 */
		String valor2 = "valor";
		Optional<String> valorOptional = Optional.ofNullable(valor2);
		
		
	}
	

	private static void log(Object o) {
		System.out.println(Thread.currentThread().getName()+"\t"+o);
	}

}
