package net.canos.java8.collections;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class Collections_000_Streams {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		/*
		 * Stream directo
		 */
		Stream<String> s = Stream.of("Hola", "Mundo");
		
		/*
		 * Stream a partir de Collections
		 */
		List<String> list = Arrays.asList("Hola2", "Mundo2");
		Stream<String> listStream = list.stream();
		
		list.sort(String::compareTo);
		
		Set<String> set = new HashSet<>(list);
		Stream<String> setStream = set.stream();
			
		
		
	}

}
