package net.canos.java8.collections;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Collections_004_Streams_Usage_Basic {

	public static void main(String[] args) {

		Person busi = new Person("Busquets",29, Position.DEFENSA);
		
		List<Person> rosterRepetidos = Arrays.asList(
			new Person("Cañizares",48, Position.PORTERO),
			new Person("Busquets",29, Position.DEFENSA),
			new Person("Busquets",29, Position.DEFENSA),
			new Person("Sempere",60, Position.PORTERO),
			new Person("Nuno",25, Position.PORTERO),
			new Person("Djukic",48, Position.DEFENSA),
			new Person("Camarasa",69, Position.DEFENSA),
			new Person("Busquets",29, Position.DEFENSA),
			busi, busi, busi, 
			new Person("Busquets",29, Position.DEFENSA),
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
		 * UPDATE 1. count
		 */
		System.out.println("\n\nUPDATE 1");
		long cantidad = rosterRepetidos.stream().count();
		System.out.println("Roster:"+cantidad);
		
		/*
		 * UPDATE 2. distinct
		 */		
		System.out.println("\n\nUPDATE 2");
		Stream<Person> sinRepetidos = rosterRepetidos.stream().distinct();
		System.out.println("Roster sin repetidos:"+sinRepetidos.count());
		
		/*
		 * UPDATE 3. skip
		 */
		System.out.println("\n\nUPDATE 3");
		long sinRepetidosSkip3 = rosterRepetidos.stream()
				.sorted( (p1, p2) -> p1.getName().compareTo(p2.getName()) )
				.distinct()
				.skip(3)
				.count();
		System.out.println("Roster sin repetidos y skip:"+sinRepetidosSkip3);
		
		/*
		 * UPDATE 4. limit
		*/
		System.out.println("\n\nUPDATE 4");
		long limit = rosterRepetidos.stream().distinct()
				.limit(3)
				.count();
		System.out.println("Roster sin repetidos y limit:"+limit);
		 
		/*
		 * UPDATE 5. Sorted
		 */
		System.out.println("\n\nUPDATE 5 sorted");
		int filterType = 3;
		 List<String> restoreNoRepetidosyOrdenados = rosterRepetidos.stream()
				.distinct()
				.sorted((x,y) -> x.compareTo(y))
				//.sorted(Person::compareTo)				
				.map(p -> p.getName())
				.collect(Collectors.toList());
		System.out.println(rosterRepetidos);
		System.out.println(restoreNoRepetidosyOrdenados);
		 
		/*
		 * Si queremos usar
		 */
		System.out.println("\n\nUPDATE 5 sorted");
		 List<String> restoreNoRepetidosyOrdenados2 = rosterRepetidos.stream()
				.distinct()
				.sorted()
				.map(p -> p.getName())
				.sorted()
				.collect(Collectors.toList());
		System.out.println(restoreNoRepetidosyOrdenados2);
 
		/*
		 * UPDATE 6. Min
		 */
		System.out.println("\n\nUPDATE 6 min");
		Optional<Person> min = rosterRepetidos.stream()
				.distinct()
				.min(Person::compareTo);
		System.out.println(min.get().getName());
		 

		/*
		 * UPDATE 7. min
		 */
		System.out.println("\n\nUPDATE 7 max");
		Optional<Person> max = rosterRepetidos.stream()
				.distinct()
				.max(Person::compareTo);
		System.out.println(max.get().getName());
 
		/*
		 * UPDATE 8. peek
		 */
		System.out.println("\n\nUPDATE 8");
		int ole = 50;
		rosterRepetidos.stream()
			.filter(p -> p.getAge() > 40)
			.peek(v -> System.out.println("más 40 años => "+v))
			.peek(p -> p.setAge(ole)) // TODO mejorar ejemplo 
			.collect(Collectors.toList())
				.forEach(System.out::println);
	
		 /*
			.map(p -> p.getName())
			.filter(p -> p.contains("i"))
			.peek(v -> System.out.println("contienen i => "+v))
			.filter(p -> p.contains(" "))
			.peek(v -> System.out.println("tienen blank=> "+v))
			.collect(Collectors.toList());*/
		
		
		
	}

}
