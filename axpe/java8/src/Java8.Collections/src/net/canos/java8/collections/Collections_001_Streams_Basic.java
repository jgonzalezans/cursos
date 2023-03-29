package net.canos.java8.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Collections_001_Streams_Basic {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("Hola", "Mundo");
		Stream<String> listStream = list.stream();
		
		/*
		 * Functional-style
		 */
		List<String> listaFiltradita = listStream
			.filter(x -> x.startsWith("H"))
			.filter(x -> x.length() > 3)
			//.filter(x -> )
			.filter(x -> true)
			.collect(Collectors.toList()); 
			
		System.out.println(listaFiltradita);
		
		/*
		 * Iterative-style
		List<String> l2 = new ArrayList<>();
		for(String s : list) {
			if(s.startsWith("H") && s.length() > 3) {
				l2.add(s);
			}
			if() {
				if() {
					
				}
				else {
					
				}
			}
			
			if() {
				
			}		
		} 
		*/

		
		
		
		
		
		
		
		
		
		/*
		 * UPDATE 1. Filter
		 */	
		listStream = list.stream();
		Stream<String> sFiltrada = listStream
				.filter(e -> e.startsWith("M"))
				.filter(e -> e.endsWith("undo"));
		
			
		/*
		 * UPDATE 2. Map con objetos reales
		 */	
		List<Person> roster = Arrays.asList(
				new Person("Guedes",25), 
				new Person("Marcelino",50), 
				new Person("Parejo",35));

		List<String> names = roster.stream()
			.filter(p -> p.getAge() < 45)
			.map(p -> p.getName())
			.filter(n -> n.contains("u"))
			.collect(Collectors.toList());
		System.out.println("\n\nSegundo resultado tras filter y map:"+names.toString());
		
		
		
		
		
	}

}
