package test;

import java.util.Arrays;
import java.util.List;

/**
 * Tenemos una lista con nombres de personas
 * 
 * Se pide:
 * 
 * 1.- Nombres de todas las personas, no repetidas
 * 
 * 2.- Total de personas, no repetidas, cuyo nombre empieza por "a"
 * 
 * 3.- Nombre de todas las personas, no repetidas, que tengan más de cinco caracteres
 * 
 * @author joseg
 *
 */

public class Test {

	public static void main(String[] args) {

		List<String> lista = Arrays.asList("María","Miguel","Pepe","Paco","Pepe","Ana","Mohamed","Miguel");
		
		//1.- Nombres de todas las personas, no repetidas
		lista.stream().
		distinct()
		.forEach(a->System.out.println(a));
		
		//2.- Total de personas, no repetidas, cuyo nombre empieza por "a"
		System.out.println(
				lista.stream().
				distinct()
				.filter(a->a.toLowerCase().startsWith("a"))
				.count()
		);
		
		//3.- Nombre de todas las personas, no repetidas, que tengan más de cinco caracteres
		lista.stream().
		distinct()
		.filter(a->a.length()>5)
		.forEach(a->System.out.println(a));
	}

}
