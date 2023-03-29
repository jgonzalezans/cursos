package net.canos.java8.collections;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Collections_016_Streams_Maps {

	public static void main(String[] args) {
		
		/* 
		 * update 1 Con HashMaps
		 * Imaginador que obtenemos de dos queries a la base de datos
		 * Estas dos fuentes de datos
		 */
		List<Person> roster = Arrays.asList(
				new Person("Cañizares",48, Position.PORTERO, 
						Arrays.asList(Position.PORTERO, Position.DELANTERO)),
				new Person("Sempere",60, Position.PORTERO, 
						Arrays.asList(Position.PORTERO, Position.CENTROCAMPISTA)),
				new Person("Nuno",25, Position.PORTERO, 
						Arrays.asList(Position.PORTERO, Position.DEFENSA)));

		List<Person> roster2 = Arrays.asList(
				new Person("Djukic",48, Position.DEFENSA, 
						Arrays.asList(Position.DEFENSA, Position.CENTROCAMPISTA)),
				new Person("Camarasa",69, Position.DEFENSA, 
						Arrays.asList(Position.DEFENSA, Position.CENTROCAMPISTA)),
				new Person("Busquets",29, Position.DEFENSA, 
						Arrays.asList(Position.DEFENSA, Position.CENTROCAMPISTA)),
				new Person("Guedes",25, Position.CENTROCAMPISTA, 
				Arrays.asList(Position.CENTROCAMPISTA, Position.DELANTERO)));
		
		/*
		 * Por avatares del destino, acaban en un HashMap
		 * Ejemplo tipo en algunos ORM 
		 */
		HashMap<Integer,List<Person>> aux1 = new HashMap<>();
		aux1.put(1, roster);
		
		HashMap<Integer,List<Person>> aux2 = new HashMap<>();
		aux2.put(2, roster2);

		/*
		 * UPDATE 1. Uso foreach en Maps
		 */
		System.out.println("UPDATE 1. Uso del foreach:");
		aux1.forEach((i, people) -> {
			people.forEach(System.out::println);
		});
		
		/*
		 * UPDATE 2. Uso merge en Map
		 */
		System.out.println("UPDATE 2. Uso del merge:");
		Map<String, Integer> v = new HashMap<>();
		v.put("1", 1);
		v.put("2", 2);		
		v.merge("3", 3, (i,vv) -> vv*2);
		v.merge("1", 1, (i,vv) -> vv*69);
		System.out.println(v.toString());
		
		
		/**
		 * Para volvernos locos vamos a meter todo eso e un HashMap adicional
		 */
		Map<Integer, Map<Integer, List<Person>>> trambolic = new HashMap<>();
		trambolic.put(1, aux1);
		trambolic.put(2, aux2);
		
		
		
		/* 
		 * Dada la historia anterior, agrupar en una única lista
		 */
		System.out.println("UPDATE 3: ");
		trambolic.values().stream()
			.map(e -> e.values())
			.flatMap(e -> e.stream())
			.flatMap(e -> e.stream())
			.collect(Collectors.toList())
			//.filter(p -> p.getAge() > 18)
			//.mapToInt(p -> p.getAge())
			//.sum();
			.forEach(System.out::println);
	}

}
