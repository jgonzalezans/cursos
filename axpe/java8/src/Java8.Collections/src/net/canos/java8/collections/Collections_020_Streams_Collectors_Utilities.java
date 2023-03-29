package net.canos.java8.collections;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

	
public class Collections_020_Streams_Collectors_Utilities {

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
		 * UPDATE 1.  Collectors.joining()
		 */		
		System.out.println("\n\nUPDATE 3. ");
		String names = roster.stream()
			.map(p -> p.getName())
			.collect(Collectors.joining(", "));
		System.out.println("Names:"+names);	
		
		System.out.println("\n\nUPDATE 3 Extraball. ");
		String names2 = roster.stream()
			.map(p -> p.getName())
			.collect(Collectors.joining(", ","[","]"));
		System.out.println("Names:"+names2);	
	
		/*
		 * UPDATE 2.  Collectors.counting()
		 */
		System.out.println("\n\nUPDATE 2. ");
		Long elements = roster.stream()
			.collect(Collectors.counting());
		System.out.println("Todos elements:"+elements);

		/*
		 * UPDATE 3.  Collectors.counting()
		 */
		Long elements2 = roster.stream()
				.filter(p -> p.getAge() > 30)
				.filter(p -> p.getAge() % 2 == 0)
				.collect(Collectors.counting());
		System.out.println("Elements > 30 y pares:"+elements2);
		

		/*
		 * UPDATE 4.  Collectors.mapping()
		 * Permite cambiar el formato y el resultado pasarlo por otro Collector.
		 */
		List<String> names1 = roster.stream()
				.filter(p -> p.getAge() > 30)
				//.map(p -> p.getName().toUpperCase())
				
				//.collect(Collectors.toList());
				.collect(Collectors.mapping(p -> p.getName().toUpperCase(), Collectors.toList()));
		System.out.println("names1:"+names1);
		
		String aficio = roster.stream()
				.filter(p -> p.getMainPosition().equals(Position.AFICIÓN))
				.collect(Collectors.mapping(p -> p.getName().toUpperCase(), Collectors.joining(", ")));
		System.out.println("Afició con mayúsculas:"+aficio);
		
		List<String> aficioNames = roster.stream()
				.filter(p -> p.getMainPosition().equals(Position.AFICIÓN))
				.collect(Collectors.mapping(p -> p.getName().toUpperCase(), Collectors.toList()));
		System.out.println("Afició con mayúsculas:"+aficioNames);
	}

}
