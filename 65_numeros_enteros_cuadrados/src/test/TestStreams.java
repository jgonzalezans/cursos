package test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Realizar un programa que, partiendo de una lista de números enteros, muestre
 * el cuadrado de cada número par y la raiz cuadrada de los positivos
 * 
 * @author joseg
 *
 */
public class TestStreams {

	public static void main(String[] args) {

		ArrayList<Integer> lista = new ArrayList<>();

		lista.add(1);
		lista.add(5);
		lista.add(5);
		lista.add(8);
		lista.add(4);
		lista.add(-6);

		System.out.println("Lista de todos los numeros enteros "+lista);

		System.out.println("Lista de los cuadrados de los pares");
		List<Integer> listaCuadradosPares = lista.stream()
									.map(s -> s * s)
	                                .filter(number -> number % 2 == 0)
	                                .collect(Collectors.toList());
	    listaCuadradosPares.forEach(s->System.out.println(s));
	    
	    System.out.println("Lista de la raíz cuadrada de los positivos");
	    List<Integer> listaRaizPositivos = lista.stream()
						    		.map(s -> (int)Math.sqrt(s))
						    		.filter(number -> number >= 0)
						    		.collect(Collectors.toList());
	    listaRaizPositivos.forEach(s->System.out.println(s));
	    
	    System.out.println("Lista original"+lista);
	}

}
