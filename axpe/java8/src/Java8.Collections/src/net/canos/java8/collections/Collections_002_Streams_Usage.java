package net.canos.java8.collections;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Collections_002_Streams_Usage {

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
		 * UPDATE 1, analicemos cómo se comporta
		 */
		List<String> names2 = roster.stream()
			.filter( p -> {
				System.out.println("filter "+p.getName());
				return p.getAge() < 30;	
			})
			.map(p -> {
				System.out.println("map "+p.getName());
				return p.getName();
			})
			.collect(Collectors.toList());
		
		/*
		 * ¿Qué pasa si quito el collect?
		 */
		
		System.out.println(names2);
	}
}


