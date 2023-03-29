package com.canos.java.java7;

public class BinaryIntegerLiterals {

	public static void main(String[] args) {
		int numero6 = 0b110;		
		log(numero6);
		
		int numero5 = 5;
		log(numero5 + numero6);
		
		/*
		 * Antes de Java SE 7 sólo se podía hacer con bytes
		 */
		byte numero37 = 0b0010_0101;
		log(numero37);
		log(numero37 + numero5);
	}

	private static void log(Object o) {
		System.out.println(o.toString());
	}
}
