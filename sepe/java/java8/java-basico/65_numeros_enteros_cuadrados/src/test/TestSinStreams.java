package test;

import java.util.ArrayList;

/**
 * Realizar un programa que, partiendo de una lista de números enteros, muestre
 * el cuadrado de cada número par y la raiz cuadrada de los positivos
 * 
 * 
 * @author joseg
 *
 */
public class TestSinStreams {
/*FIXME: SIN USAR STREAMS NO SÉ COMO HACER USANDO PROGRAMACIÓN FUNCIONAL Y SIN QUE SEA DEMASIADO ENGORROSO QUE:
 * LA LISTA ORIGINAL NO SE MODIFIQUE... SI HACES UN REMOVEIF O REPLACEALL TE LA CARGAS...
 * APLICAR FILTROS A LO QUE SE MUESTRA CON FOREACH...ES DECIR UN PREDICATE
 * HACERLO A LA VEZ EN UNA SENTENCIA, ES DECIR CONCATENANDO LLAMADAS...
 * CREO QUE ESTÁ PUESTO PARA PENSAR Y VER EL USO DE STREAMS...
 *  
 */
	public static void main(String[] args) {

		ArrayList<Integer> lista = new ArrayList<>();

		lista.add(1);
		lista.add(5);
		lista.add(5);
		lista.add(8);

		System.out.println("Lista original" + lista);
		lista.forEach(n -> System.out.println(n));

		lista.removeIf(n -> n % 2 != 0);

		System.out.println("Lista de pares" + lista);
		lista.forEach(n -> System.out.println(n));

		lista.replaceAll(n -> n * n);

		System.out.println("Lista de pares al cuadrado" + lista);
		lista.forEach(n -> System.out.println(n));

//		List<String> numbers = Arrays.asList("1", "2", "3", "4", "5", "6");
//	    System.out.println("original list: " + numbers);
//
//	    List<Integer> even = numbers.stream()
//	                                .map(s -> Integer.valueOf(s))
//	                                .filter(number -> number % 2 == 0)
//	                                .collect(Collectors.toList());
//
//	    System.out.println("processed list, only even numbers: " + even);
	}

}
