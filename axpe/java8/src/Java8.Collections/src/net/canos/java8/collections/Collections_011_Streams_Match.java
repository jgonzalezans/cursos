package net.canos.java8.collections;

import java.util.Arrays;
import java.util.List;


public class Collections_011_Streams_Match {

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
		 * UPDATE 1. allMatch
		 * Operación terminal y boolean
		 */
		boolean enEdadDeTrabajar = roster.stream()
				.allMatch(p -> p.getAge() < 65);
		System.out.println("Estan todos en edad de trabajar? "+enEdadDeTrabajar);
		
		/*
		 * UPDATE 2. anyMatch
		 * Operación terminal y boolean
		 */
		enEdadDeTrabajar = roster.stream()
				.anyMatch(p -> p.getAge() < 65);
		System.out.println("Hay alguien en edad de trabajar? "+enEdadDeTrabajar);
		
		/*
		 * UPDATE 3. noneMatch
		 * Operación terminal y boolean
		 */
		enEdadDeTrabajar = roster.stream()
				.noneMatch(p -> p.getAge() < 67 && p.getAge() > 65);
		System.out.println("No hay ninguno entre 65 y 67? "+enEdadDeTrabajar);
		
	}

}
