package net.canos.java8.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class Collections_022_Streams_Collectors_toCollection {

	public static void main(String[] args) {

		List<Person> roster = Arrays.asList(
				new Person("Guedes",25), 
				new Person("Marcelino",50), 
				new Person("Parejo",35),
				new Person("Lato",20), 
				new Person("Javier Fernandez", 27), 
				new Person("Marco Polo", 88), 
				new Person("Agustina de Aragón", 96));
		
		/*
		 * UPDATE 1.  Collectors.toList()
		 */
		System.out.println("\n\nUPDATE 1 List. ");		
		List<Person> names1 = roster.stream()
			.collect(Collectors.toList());
		
		System.out.println("List:"+names1.toString());
		
	
		/*
		 * UPDATE 2.  Collectors.toSet()
		 */		
		System.out.println("\n\nUPDATE 2 Set. ");
		Set<Person> rosterSet = roster.stream()
			.collect(Collectors.toSet());
		
		System.out.println("rosterSet:"+rosterSet.toString());

		/*
		 * UPDATE 3.  Collectors.toCollection()
		 */
		System.out.println("\n\nUPDATE 3 toCollection(..) ");
		ArrayList<Person> c = roster.stream()
			.collect(Collectors.toCollection(() -> new ArrayList<Person>()));

		LinkedList<Person> c2 = roster.stream()
			.collect(Collectors.toCollection(LinkedList::new));
		
		System.out.println("Collection ArrayList:"+c.toString()+" "+c.size());	
		System.out.println("Collection LinkedList:"+c2.toString());
		System.out.println("El último es: "+c2.peekLast());
		
		
		

	}

}
