package net.canos.java8.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


public class Collections_005_Streams_Iterator {

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
		 * UPDATE 1. forEach
		 * Operación terminal y void
		 */
		System.out.println("UPDATE 1 ");
		roster.stream()
			.filter(p -> p.getName().startsWith("M"))
			.forEach((p) -> System.out.println(p.getName()));
		
		/*
		 * UPDATE 2. iterator
		 * Operación terminal y void
		 */
		System.out.println("\n\nUPDATE 2 ");
		Iterator<Person> it = roster.stream().iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		/*
		 * UPDATE 3. toArray
		 */
		System.out.println("\n\nUPDATE 3");
		// Manera a través de Stream
		Person[] persons = roster.stream()
				.toArray(Person[]::new);
		System.out.println(Arrays.toString(persons));
		
		/*
		 * ToArray de la manera clásica 
		 */
		Person[] persons2 = roster.toArray(new Person[roster.size()]);
		System.out.println(Arrays.toString(persons2));
		
		/*
		 * Ventajas de usar streams
		 */
		System.out.print("Extraball:");
		String[] names = roster.stream()
				.map(p -> p.getName())
				.toArray(String[]::new);
		System.out.println(Arrays.toString(names));
		
	}

}
