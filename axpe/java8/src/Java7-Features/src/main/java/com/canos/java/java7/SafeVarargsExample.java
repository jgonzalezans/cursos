package com.canos.java.java7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SafeVarargsExample {

	/**
	 * Ejercicio 1. 
	 * Si no usamos @Safevarargs obtenemos un warning.
	 * 
	 */
	public static void main(String[] args) {
		ArrayList<Integer> a1 = new ArrayList<>();
		a1.add(new Integer(1));
		a1.add(2);
		
		ArrayList<Float> a2 = new ArrayList<>();
		a2.add(new Float(3.0));
		a2.add(new Float(4.0));
		
		displayElements(a1, a2, 12, "adiós", Arrays.asList("Hola","Mundo"));
	}

	//@SafeVarargs
	static <T> void displayElements(T... array) {
		for (T element : array) {
			System.out.println(element.getClass().getName() + ": " + element);
		}
	}

	
	/**
	 * Ejercicio 2
	 * Método INSEGURO pero erróneamente marcada como seguro
	 */
	@SafeVarargs // Not actually safe!
	static void m(List<String>... stringLists) {
		Object[] array = stringLists;
		List<Integer> tmpList = Arrays.asList(42);
		
		array[0] = tmpList; // Semantically invalid, but compiles without warnings
		
		stringLists[0].get(0); // Oh no, ClassCastException at runtime!
	}

}
