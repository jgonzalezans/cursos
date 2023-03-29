package net.canos.java8.collections;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

	
public class Collections_025_Streams_Collectors_Calculating_SOLUCION {

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
		 * 1
		 */
		Double mediaEdad = roster.stream()
			.collect(Collectors.averagingInt(p -> p.getAge()));
		
		System.out.println("Media de edad:"+mediaEdad);
		
		/*
		 * 2
		 */
		Double mediaEdadDelanteros = roster.stream()
				.filter(p -> p.getMainPosition().equals(Position.DELANTERO))
			.collect(Collectors.averagingInt(p -> p.getAge()));
		
		System.out.println("Media de edad Delanteros:"+mediaEdadDelanteros);
		
		/*
		 * 3
		 */
		Map<Position, Double> edadPorPosition = roster.stream()
			.collect(Collectors.groupingBy(p -> p.getMainPosition(), Collectors.averagingInt(p -> p.getAge()) ));
		System.out.println(edadPorPosition);
		
	}

}
