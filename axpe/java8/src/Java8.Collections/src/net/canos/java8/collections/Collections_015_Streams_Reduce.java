package net.canos.java8.collections;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Collections_015_Streams_Reduce {

	public static void main(String[] args) {
		
		/*
		 * UPDATE 1
		 */
		List<Integer> list2 = Arrays.asList(2, 3, 4);
		Optional<Integer> r = list2.stream().reduce((e1, e2) -> {
			return e1 + e2;	
		});
		System.out.println("UPDATE 1.1 resultado: "+r.orElse(-1));

		Optional<Integer> r2d2 = list2.stream()
				.reduce((e1,e2) -> e1+e2+1);
		System.out.println("UPDATE 1.2 resultado: "+r2d2.orElse(-1));

		Optional<Integer> r3 = list2.stream()
				.reduce((e1,e2) -> e1*e2);
		System.out.println("UPDATE 1.3 resultado: "+r3.orElse(-1));
		
				
		/*
		 * UPDATE 2
		 */
		List<String> listString = Arrays.asList("David", "María", "kevin");
		String r4 = listString.stream().reduce("Comienzo: ",(e1,e2) -> e1+"_"+e2);
		System.out.println("UPDATE 2.1 resultado: "+r4);
		
		/*
		 * UPDATE 3
		 */
		String r5 = listString.stream().reduce("Comienzo: ",
				(e1,e2) -> e1+"_"+e2, 
				(c1, c2) -> c1.toUpperCase()+c2);
		System.out.println("UPDATE 2.1 resultado: "+r4);
		
	}

}
