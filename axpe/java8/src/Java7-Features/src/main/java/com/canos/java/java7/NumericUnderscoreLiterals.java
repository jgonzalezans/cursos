package com.canos.java.java7;

public class NumericUnderscoreLiterals {

	public static void main(String[] args) {
		/*
		 * ¿Qué es más legible?
		 */
		int unmillon 	= 1_000_000;
		int dosmillones = 2000000;
		
		/*
		 * Aprovecho para recordar que podemos crear numeros y añadir su formato en formato sufijo.
		 * Esto es Anterior a Java SE 7
		 */
		long tres = 3000000200000000l;
		float pi = 3.14159f;
		double quebrado = 4d;
		
	}

	private static void log(Object o) {
		System.out.println(o.toString());
	}
}
