package test;

import principal.ListaEnteros;

public class ListaEnterosTest {

	public static void main(String[] args) {

		
		ListaEnteros listaEnteros = new ListaEnteros();
		
		listaEnteros.add(1);
		listaEnteros.add(5);
		listaEnteros.add(2);
		listaEnteros.add(3);
		listaEnteros.add(1);
		
		System.out.println("Lista sin ordenar");
		for (Integer entero : listaEnteros) {
			System.out.println(entero);
		}
		
		listaEnteros.invertir();
		
		System.out.println("Lista ordenada inversamente");
		for (Integer entero : listaEnteros) {
			System.out.println(entero);
		}
	}

}
