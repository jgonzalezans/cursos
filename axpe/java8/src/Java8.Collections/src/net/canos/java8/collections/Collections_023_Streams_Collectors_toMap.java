package net.canos.java8.collections;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;


public class Collections_023_Streams_Collectors_toMap {

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
		 * UPDATE 1.  Collectors.toMap(,)
		
		System.out.println("\n\nUPDATE 1 toMap. ");
		Map<String, Person> rosterMap = roster.stream()
			.collect(Collectors.toMap(p -> p.getName(), v -> v));		
		System.out.println("Map:"+rosterMap);
		 */
		
		
		/*
		 * UPDATE 2. Collectors.toMap(,,)
		 
		System.out.println("\n\nUPDATE 2 toMap y colisisón ");		
		List<Person> roster2 = Arrays.asList(
				new Person("Guedes",25), 
				new Person("Marcelino",50),
				new Person("Marcelino",52)); // Colisión de nombre
		
		Map<String, Person> roster2Map = roster2.stream()
			.collect(Collectors.toMap(p -> p.getName(), 
					v -> v, 
					//(p1, p2) -> p1.getAge() >= p2.getAge() ? p1 : p2)
					Person::eldest
					));
		
		System.out.println("Map2:"+roster2Map);
		*/
		
		/*
		 * UPDATE 3. Collectors.toMap(,,,)
		 
		System.out.println("\n\nUPDATE 3 toMap y colisisón y Supplier ");
		
		HashMap<String, Person> rosterHashMap = roster2.stream()
			.collect(Collectors.toMap( p -> p.getName(),
					v -> v, 
					(p1, p2) -> p1, 
					HashMap::new));
		
		TreeMap<String, Person> rosterTreeMap = roster2.stream()
				.collect(Collectors.toMap( p -> p.getName(), 
						v -> v, 
						(p1, p2) -> p1, 
						TreeMap::new));
		
		System.out.println("HashMap:"+rosterHashMap);
		System.out.println("TreeMap:"+rosterTreeMap);
		 */

		/*
		 * UPDATE 4. Collectors.groupingBy()
		 */
		System.out.println("\n\nUPDATE 4 groupingBy ");
		Map<Integer, List<Person>> rosterPorEdad = roster.stream()
			.collect(Collectors.groupingBy(p -> p.getAge()));
		
		System.out.println("rosterPorEdad:"+rosterPorEdad);
		System.out.println("rosterPorEdad solo 35:"+rosterPorEdad.get(35));
		System.out.println("rosterPorEdad solo 48:"+rosterPorEdad.get(48));
		 
		//System.out.println("\n\nUPDATE 4 groupingBy REAL ");
		//Map<AgeRange, List<Person>> rosterPorRangoDeEdad = roster.stream()
		//	.collect(Collectors.groupingBy(p -> Person::getAgeRange));
		
		
		/*
		 * UPDATE 5. Collectors.groupingBy()
		 */
		System.out.println("\n\nUPDATE 5 groupingBy ");
		
		Map<Integer, Long> rosterCantidadPorEdad = roster.stream()
			.collect(Collectors.groupingBy(p -> p.getAge(), Collectors.counting()));
		System.out.println("rosterCantidadPorEdad:"+rosterCantidadPorEdad);
	  
		
		/*
		 * UPDATE 5. Más interesante, agrupar y luego seguir teniendo el listado agrupado
		 */
		System.out.println("\n\nUPDATE 5 groupingBy ");
		
		Map<Integer, Set<Person>> rosterCantidadPorEdadList = roster.stream()
			.collect(Collectors.groupingBy(p -> p.getAge(), Collectors.toSet()));
		System.out.println("rosterCantidadPorEdadList:"+rosterCantidadPorEdadList);

		
		/*
		 * UPDATE 6. Collectors.partitioning() 
		 * Es un tipo especial de particion donde se agrupa por el resultado de un predicado 
		 * 
		 */
		System.out.println("\n\nUPDATE 6 partitioning ");
		Map<Boolean, List<Person>> partitioning = roster.stream()
				.collect(Collectors.partitioningBy(p -> p.getAge() < 50));
		System.out.println("Partitioning MAP:"+partitioning);
		System.out.println("Mayores de 35:"+partitioning.get(false).size());
		 
		
		/*
		 * Agrupar (particionadamente) y obtener un listado de nombres
		*/	
		Map<Boolean, Set<String>> partitioning2 = roster.stream()
				.collect(Collectors.partitioningBy(p -> p.getAge() > 35, 
						Collectors.mapping(p->p.getName(), Collectors.toSet())));
		System.out.println("\n\nPartitioning MAP:"+partitioning2);
		System.out.println("Mayores de 35:"+partitioning2.get(false).size());
		 	
		
		
	}

}
