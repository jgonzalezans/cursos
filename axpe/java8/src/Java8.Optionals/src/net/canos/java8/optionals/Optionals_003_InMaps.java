package net.canos.java8.optionals;

import java.util.Optional;

/**
 * Un pequeño ejemplo de un hola mundo desde lambdas
 * 
 * @author David Canos 
 * Twitter: @Canos
 *
 */
public class Optionals_003_InMaps {
	
	public static void main(String[] args) {
		
		/*
		 * UPDATE 1. Filters in optional
		 */
		log("UPDATE 1");
		Optional<Integer> integer = Optional.of(69);
		integer = integer.filter(x -> x == 64);
			
		boolean present = integer.filter(x -> x == 64).isPresent();
		log("present? "+present);
		

		log("UPDATE 2");
		integer = Optional.of(69);
		present = integer.filter(x -> x == 69).isPresent();
		log("present? "+present);
		
		
	}
	

	private static void log(Object o) {
		System.out.println(Thread.currentThread().getName()+"\t"+o);
	}

}
