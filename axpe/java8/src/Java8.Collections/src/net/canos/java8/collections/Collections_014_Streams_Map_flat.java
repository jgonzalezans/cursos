package net.canos.java8.collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Collections_014_Streams_Map_flat {

	public static void main(String[] args) {


		/*
		 * UPDATE 1. FlatMap
		 * Consiste en "aplanar" objetos de objetos.
		 */
		List<List<String>> listOfLists = 
			Arrays.asList(
				Arrays.asList("Lista 1-1"), 
				Arrays.asList("Lista 2-1", "Lista 2-2"));
		System.out.println("Lista original:"+listOfLists);
		
		
		// Aplanamos la lista
		List<String> simpleList = listOfLists.stream()
				.flatMap(l -> l.stream()) 
				.collect(Collectors.toList());
		System.out.println("Lista aplanada:"+simpleList);
				
		
		/*
		 * Extraball:
		 * Tambíen se puede escribir así, pero es mucho más ilegible
		 */
		listOfLists.stream()
				.flatMap(Collection::stream)
				.collect(Collectors.toList())
				.forEach(System.out::println);
			
		/*
		 * Update 2. 
		 * Ejemplo y utilidiad con listas reales
		 * El modelo de Person ahora tiene una opción más que es una lista de 
		 */
		List<Person> roster = Arrays.asList(
				new Person("Cañizares",48, Position.PORTERO, 
						Arrays.asList(Position.PORTERO, Position.DELANTERO)),
				new Person("Sempere",60, Position.PORTERO, 
						Arrays.asList(Position.PORTERO, Position.CENTROCAMPISTA)),
				new Person("Nuno",25, Position.PORTERO, 
						Arrays.asList(Position.PORTERO, Position.DEFENSA)));

		System.out.println("Update 2 aplanar objetos útiles:");
		roster.stream().flatMap(p -> p.getAlternativePositions().stream())
			.collect(Collectors.toList())
			.forEach(position -> System.out.println("position:"+position));
		
		
		/*
		 * UPDATE 3. flatMapToInt
		 
		System.out.println("\n\nUPDATE 2");
		List<List<Integer>> listOfListsIntegers = Arrays.asList(
				Arrays.asList(1), 
				Arrays.asList(11, 12));
		IntStream intStream = listOfListsIntegers.stream()
				.flatMapToInt(l -> l.stream().mapToInt(p -> p));
		System.out.println(intStream.summaryStatistics());
		//System.out.println(intStream.sum());*/
	}

}
