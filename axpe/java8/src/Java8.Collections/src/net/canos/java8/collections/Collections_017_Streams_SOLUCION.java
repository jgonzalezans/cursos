package net.canos.java8.collections;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;


public class Collections_017_Streams_SOLUCION {

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
		OptionalDouble edad = roster.stream()
			.filter(p -> p.getMainPosition().equals(Position.CENTROCAMPISTA))
			.mapToInt(p -> p.getAge())
			.average();
		System.out.println("Edad media centrocampistas:"+edad.getAsDouble());
		
		/*
		 * EJERCICIO 2
		 */
		OptionalDouble edad2 = roster.stream()
			.filter(p -> p.getMainPosition().equals(Position.CENTROCAMPISTA))
			.sorted()
			.skip(1)
			.sorted((p1, p2) -> p1.compareTo(p2)*-1)
			.skip(1)
			.mapToInt(p -> p.getAge())
			.average();
		System.out.println("Edad media sin el centrocampista más joven y el más viejo:"+edad2.getAsDouble());
		
		/*
		 * EJERCICIO 3
		 */
		System.out.println("\n\nEjercicio 3");
		Integer sumaEdadCentro = roster.stream()
			.filter(p -> p.getMainPosition().equals(Position.CENTROCAMPISTA))
			.map(p -> p.getAge())
			.reduce(Integer::sum).get();
		
		Integer sumaEdadPortero = roster.stream()
				.filter(p -> p.getMainPosition().equals(Position.PORTERO))
				.map(p -> p.getAge())
				.reduce(Integer::sum).get();
		
		Integer sumaEdadDefensa = roster.stream()
				.filter(p -> p.getMainPosition().equals(Position.DEFENSA))
				.map(p -> p.getAge())
				.reduce(Integer::sum).get();
		
		Integer sumaEdadAficion = roster.stream()
				.filter(p -> p.getMainPosition().equals(Position.AFICIÓN))
				.map(p -> p.getAge())
				.reduce(Integer::sum).get();
		
		System.out.println(sumaEdadCentro);
		System.out.println(sumaEdadPortero);
		System.out.println(sumaEdadDefensa);
		System.out.println(sumaEdadAficion);
	}

}
