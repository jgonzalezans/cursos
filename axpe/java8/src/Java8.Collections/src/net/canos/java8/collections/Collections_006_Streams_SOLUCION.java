package net.canos.java8.collections;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;


public class Collections_006_Streams_SOLUCION {

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
		 * EJERCICIO 1
		 */
		long edad = roster.stream()
			.filter(p -> p.getMainPosition().equals(Position.CENTROCAMPISTA))
			.min(Person::compareTo)
			.get().getAge();
		System.out.println("Edad centrocampista más joven:"+edad);
		
		/*
		 * EJERCICIO 2
		 */
		long edad2 = roster.stream()
			.filter(p -> p.getMainPosition().equals(Position.CENTROCAMPISTA))
			.sorted()
			.skip(1)
			.min(Person::compareTo)
			.get().getAge();
		System.out.println("Edad 2º centrocampista más joven:"+edad2);
		
		/*
		 * EJERCICIO 3
		 */
		System.out.println("Ejercicio 3");
		roster.stream()
			.filter(p -> p.getMainPosition().equals(Position.CENTROCAMPISTA))
			.sorted()
			.skip(1)
			.sorted((p1, p2) -> p1.compareTo(p2)*-1)
			.skip(1)
			.sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
			.map(p -> p.getName())
			.collect(Collectors.toList())
			.forEach(System.out::println);
		
		
	}

}
