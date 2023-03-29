package net.canos.java8.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Collections_003_Streams_Usage_SOLUCION {

	public static void main(String[] args) {
		
		List<Person> roster = Arrays.asList(
			new Person("Cañizares",48, Position.PORTERO),
			new Person("Sempere",60, Position.PORTERO),
			new Person("Nuno",25, Position.PORTERO),
			new Person("Djukic",48, Position.DEFENSA),
			new Person("Camarasa",69, Position.DEFENSA),
			new Person("Busquets",29, Position.DEFENSA),
			new Person("Guedes",25, Position.CENTROCAMPISTA), 
			new Person("Marcelino",50, Position.CENTROCAMPISTA), 
			new Person("Parejo",35, Position.CENTROCAMPISTA),
			new Person("Lato",20, Position.CENTROCAMPISTA), 
			new Person("Zaza",31, Position.DELANTERO),
			new Person("Mista",50, Position.DELANTERO),
			new Person("Villa",42, Position.DELANTERO),
			new Person("Javier Fernandez", 27, Position.AFICIÓN), 
			new Person("Marco Polo", 88, Position.AFICIÓN), 
			new Person("Agustina de Aragón", 96, Position.AFICIÓN));
		
		/*
		 * ENUNCIADO 1. Dado un array quiero el nombre de los que están entre 20-35.
		 */
		System.out.println("EJERCICIO 1");
		roster.stream()
			.filter(p -> p.getAge() > 20)
			.filter(p -> p.getAge() < 35)
			.map(p -> p.getName())
			.collect(Collectors.toList())
			.forEach(System.out::println);
			//.forEach((s) -> System.out.println(s));
		
		/* 
		 * ENUNCIADO 2. Dado un array quiero el nombre de los que están entre 20-35 
		 * y son Centrocampistas.
		 */
		System.out.println("\n\nEJERCICIO 2");
		roster.stream()
			.filter(p -> p.getAge() > 20)
			.filter(p -> p.getAge() < 35)
			.filter(p -> p.getMainPosition().equals(Position.CENTROCAMPISTA))
			.map(p -> p.getName())
			.collect(Collectors.toList())
			.forEach(System.out::println);
		
		/* 
		 * ENUNCIADO 3. Saber cuántos no delanteros tienen menos de 35 años.
		 */
		System.out.println("\n\nEJERCICIO 3");
		long n = roster.stream()
			.filter(p -> p.getAge() < 35)
			.filter(p -> !p.getMainPosition().equals(Position.DELANTERO))
			.count();
		System.out.println(n);
		

		
		
		
		
		
		
		
		
		
		
		
		/*
		 * ENUNCIADO 4. Saber la edad del centrocampista o delantero más joven.
		 */
		System.out.println("\n\nEJERCICIO 4");
		roster.stream()
			.filter(p -> p.getMainPosition().equals(Position.DELANTERO) || p.getMainPosition().equals(Position.CENTROCAMPISTA))
			.min(Person::compareTo)
			.map(p -> p.getAge())
			.ifPresent(System.out::println);
		
		roster.stream()
			.filter(p -> p.getMainPosition().equals(Position.DELANTERO) || p.getMainPosition().equals(Position.CENTROCAMPISTA))
			.map(p -> p.getAge())	
			.min(Integer::compareTo).get();
		
		roster.stream()
			.filter(p -> p.getMainPosition().equals(Position.DELANTERO) || p.getMainPosition().equals(Position.CENTROCAMPISTA))
			.mapToInt(p -> p.getAge())
			.min().getAsInt();
					
		
		
		
		
		
		
		/*
		 * ENUNCIADO 5. Saber la edad del centrocampista Y delantero más joven.
		 */
		System.out.println("\n\nEJERCICIO 5");
		List<Person> aux = roster.stream()
			.filter(p -> p.getMainPosition().equals(Position.DELANTERO) || 
					p.getMainPosition().equals(Position.CENTROCAMPISTA))
			.sorted()
			.collect(Collectors.toList());
		
		aux.stream()
				.filter(p -> p.getMainPosition().equals(Position.DELANTERO))
				.findFirst()
				.ifPresent(System.out::println);
		
		aux.stream()
				.filter(p -> p.getMainPosition().equals(Position.CENTROCAMPISTA))
				.findFirst()
				.ifPresent(System.out::println);
		
		
		
	}
}


