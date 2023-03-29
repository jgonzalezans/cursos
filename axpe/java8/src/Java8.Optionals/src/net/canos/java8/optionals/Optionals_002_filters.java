package net.canos.java8.optionals;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Un pequeño ejemplo de un hola mundo desde lambdas
 * 
 * @author David Canos 
 * Twitter: @Canos
 *
 */
public class Optionals_002_filters {
	
	private static final Integer DEFAULT_AGE = 34;

	public static void main(String[] args) {
		
		Person p = new Person("David", 60);
		Optional<Person> o = Optional.of(p);	
		
		
		/*
		 * UPDATE 1. Inicialización bajo filtro complejo
		 */
		boolean b = o
				.map(x -> x.getAge())
				.filter(x -> x > 40)
				.isPresent();
		
		Integer pp = o
				.map(x -> x.getAge())
				.filter(x -> x > 40)
				.orElse(DEFAULT_AGE);

		log("Persons < 40:"+b);
		
		
		/*
		 * UPDATE 2. Filtro 2 negativo
		 */
		boolean b2 = o
				.map(x -> x.getAge())
				.filter(x -> x < 20)
				.isPresent();
		
		
		log("Persons < 20:"+b2);
		
		
	}
	

	private static void log(Object o) {
		System.out.println(Thread.currentThread().getName()+"\t"+o);
	}

}
