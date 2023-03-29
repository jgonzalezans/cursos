package net.canos.java8.collections;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

	
public class Collections_026_Streams_Collectors_Calculating_SOLUCION2 {

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
		 * 
		 * ANTES DE CONTINUAR:
		 * 
		 * EJERCIO 1) Sumar la edad de todos  
		 * 
		 * EJERCICIO 2) Sumar la edad de todos los delanteros
		 * 
		 * EJERCICIO 3) Sumar la edad por posición
		 * 
		 * EJERCICIO 4) La media de edad por posición
		 * 
		 * EJERCICIO 5) El jugador de más edad por posición 
		 * 
		 */

		/*
		 * 1
		 */
		Integer totalEdad = roster.stream()
			.collect(Collectors.summingInt(p -> p.getAge()));
		
		System.out.println("Total de edad:"+totalEdad);
		
		/*
		 * 2
		 */
		Integer sumaEdadDelanteros = roster.stream()
			.filter(p -> p.getMainPosition().equals(Position.DELANTERO))
			.collect(Collectors.summingInt(p -> p.getAge()));
		
		System.out.println("Suma de edad Delanteros:"+sumaEdadDelanteros);
		
		/*
		 * 3
		 */
		Map<Position, Integer> sumaEdadPorPosition = roster.stream()
			.collect(Collectors.groupingBy(p -> p.getMainPosition(), Collectors.summingInt(p -> p.getAge()) ));
		System.out.println(sumaEdadPorPosition);
		

		/*
		 * 4
		 */
		Map<Position, Double> mediaEdadPorPosicion = roster.stream()
			.collect(Collectors.groupingBy(p -> p.getMainPosition(), Collectors.averagingInt(p -> p.getAge())));
		System.out.println(mediaEdadPorPosicion);
		
		/*
		 * 5
		 */
		Map<Position, Optional<Person>> posicionMaximaEdad = roster.stream()
			.collect(Collectors.groupingBy(p -> p.getMainPosition(), Collectors.maxBy(Person::compareTo)));
		
		posicionMaximaEdad.get(Position.AFICIÓN)
			.ifPresent(System.out::println);
		
		
	}

}
