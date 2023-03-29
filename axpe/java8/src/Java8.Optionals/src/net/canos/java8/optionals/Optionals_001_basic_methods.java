package net.canos.java8.optionals;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Un pequeño ejemplo de un hola mundo desde lambdas
 * 
 * @author David Canos 
 * Twitter: @Canos
 *
 */
public class Optionals_001_basic_methods {
	
	public static void main(String[] args) {
		
		/*
		 * UPDATE 1. ifPresent
		 */
		log("UPDATE 1");
		Optional<String> string = Optional.empty();
		string.ifPresent((x) -> log(x));

			
		/*
		 * UPDATE 2. ifPresent
		 */
		log("UPDATE 2");
		Optional<Integer> integer = Optional.of(69);
		integer.ifPresent((x) -> log(x));
		
		/*
		 * UPDATE 3. orElse
		 * Una buena manera de poder obtener un valor por defecto
		 */
		log("UPDATE 3");
		Integer defaultNum = Optional.<Integer>ofNullable(null).orElse(18);
		log(defaultNum); 
		
		/*
		 * UPDATE 4. orElse
		 * Una buena manera de poder obtener un valor por defecto
		 */
		log("UPDATE 4");
		Integer defaultAge = Optional.<Integer>ofNullable(null).orElseGet(() -> 18);
		log(defaultAge);
		
		/*
		 * UPDATE 5. orElseThrow
		 */
		log("UPDATE 5");
		//Optional.ofNullable(null).orElseThrow(IllegalArgumentException::new);
		
		
		/*
		 * UPDATE 6
		 */
		log("\n\nUPDATE 6");
		Integer suma = Stream.<Integer>of(1,null,2,3,4)
			.peek(x -> log(x))
			.filter(x -> x != null)
			.mapToInt(x -> x)
			.sum();
		log("UPDATE 6:"+suma);
		
		/*
		 * UPDATE 7
		 */
		log("\n\nUPDATE 7");
		Integer suma2 = Stream.<Optional<Integer>>of(Optional.of(1),Optional.empty(),Optional.of(2), Optional.of(3), Optional.of(4))
			.peek(x -> log(x))
			//.filter(x -> x.isPresent())	
			.mapToInt(x -> x.orElse(0))
			.sum();
		log("UPDATE 7:"+suma2);
		
	}
	

	private static void log(Object o) {
		System.out.println(Thread.currentThread().getName()+"\t"+o);
	}

}
