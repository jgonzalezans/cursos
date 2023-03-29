package principal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Realizar un método que reciba una lista o un conjunto de numeros enteros y devuelva la suma de todos sus elementos.
 * 
 * Realizar un metodo que recibe un conjunto de numeros enteros y devuelve una lista con el contenido de dicho conjunto
 * 
 * @author joseg
 *
 */
public class SumaCollection {

	public static void main(String[] args) {
		
		ArrayList<Integer> numeros = new ArrayList<>();
		
		numeros.add(1);
		numeros.add(1);
		numeros.add(1);
		numeros.add(1);
		numeros.add(6);
		
		System.out.println(suma(numeros));
		
		
		HashSet<Integer> numerosSueltos = new HashSet<>();
		
		numerosSueltos.add(1);
		numerosSueltos.add(1);
		numerosSueltos.add(1);
		numerosSueltos.add(1);
		numerosSueltos.add(7);
		System.out.println(suma(numerosSueltos));
		
	}

	private static int suma(Collection<Integer> numeros) {
		
		int suma = 0;

		for (Integer integer : numeros) {
			suma+=integer;
		}

		return suma;
	}
	
	private static List<Integer> transformar(Set<Integer> numeros) {
		
		ArrayList<Integer> lista = new ArrayList<Integer>();
		lista.addAll(numeros);
		return lista;
		
	
	}

}
