package test;

import java.util.ArrayList;

import service.OperacionesService;

/**
 * Realizar un programa que, partiendo de una lista de n�meros enteros, muestre
 * el cuadrado de cada n�mero par y la raiz cuadrada de los positivos
 * 
 * @author joseg
 *
 */
public class Test {

	public static void main(String[] args) {

		ArrayList<Integer> lista = new ArrayList<>();
		lista.add(1);lista.add(5);lista.add(5);lista.add(8);lista.add(4);lista.add(-6);
		
		OperacionesService operacionesService = new OperacionesService();
		
		System.out.println("Lista de todos los numeros enteros "+lista);

		System.out.println("Lista de los cuadrados de los pares");
		operacionesService.procesar(lista,
									n -> n * n,
									number -> number % 2 == 0,
									n->System.out.println(n));

	    System.out.println("Lista de la ra�z cuadrada de los positivos");
	    operacionesService.procesar(lista,
	    							n -> (int) Math.sqrt(n),
	    							number -> number >= 0,
	    							n->System.out.println(n));
	}

}
