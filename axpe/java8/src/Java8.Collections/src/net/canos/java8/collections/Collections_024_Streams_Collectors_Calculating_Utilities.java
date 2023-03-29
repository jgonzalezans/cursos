package net.canos.java8.collections;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

	
public class Collections_024_Streams_Collectors_Calculating_Utilities {

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
		 * UPDATE 1.  Collectors.minby() maxBy 
		 */
		Optional<Person> pMax = roster.stream()
			.collect(Collectors.maxBy( (p1,p2) -> p1.getAge().compareTo(p2.getAge())));
		System.out.println("max:"+pMax.get().getName());
		
		Optional<Person> pMin = roster.stream()
				.collect(Collectors.minBy( (p1,p2) -> p1.getAge().compareTo(p2.getAge())));
		System.out.println("min:"+pMin.get().getName());
		
		/*
		 * UPDATE 2. Sumarizar
		 */
		IntSummaryStatistics sumario = roster.stream()
			.collect(Collectors.summarizingInt(Person::getAge));
		System.out.println("IntSummaryStatistics:"+sumario.toString());

			
	}

}
