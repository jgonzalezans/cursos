package net.canos.java8.lambdas;

import java.util.Arrays;
import java.util.List;

/**
 * Vamos a crear una lambda una función que ya exista
 * 
 * @author David Canós
 * Twitter @Canos
 */
public class Lambda_008_OperadorDosDosPuntos {
	
	public static void main(String... args) {

		List<Integer> fib = Arrays.asList(55,1,2,1,3,5,8,13,21,34,55);
		//System.out.println(fib);
//		
		fib.forEach(System.out::println);
		
		
		
		
		
		
		
		
		/*
		 * El operador :: es una lambda en sí mismo
		 */
		fib.sort((e1,e2) -> e1.compareTo(e2));
		fib.sort(Integer::compareTo);
		
		System.out.println(fib);
		 
		
		/*
		 * Un método existente y conocido: parseInt es tratado como una lambda
		
		IntegerParser parser = Integer::parseInt;		
		int valor = parser.apply("8");
		
		System.out.println("Valor:"+valor);
		System.out.println("Se puede operar:"+valor*2);
		
		 */
    }


	@FunctionalInterface
    interface IntegerParser {
        int apply(String integer);
    }
    
}