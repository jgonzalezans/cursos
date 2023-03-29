package test;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * REALIZAR UN PROGRAMA QUE SIMULE LA COMBINACI�N GANADORA DE LA PRIMITIVA.
 * GENERA ALEATORIAMENTE 6 N�MEROS ALEATORIOS ENTRE 1 Y 49.
 * NO SE PUEDEN REPETIR LOS N�MEROS
 * Y MOSTRARLOS DE MENOR A MAYOR
 * 
 * @author joseg
 *
 */
public class Test {

	public static void main(String[] args) {

		//FIXME: ES EFICIENTE CREAR UN STREAM "INFINITO" AUNQUE SOLO "VIVA" UN TIEMPO?
		//RESPUESTA: NO ES INFINITO SINO QUE SE VAN EJECUTANDO LAS OPERACIONES INTERMEDIAS EN PARALELO.
		
		
		//Lo m�s simple con lo que se ped�a
		Stream.generate(
				() -> (int)(Math.random()*49+1))
				.distinct()
				.limit(6)
				.sorted()
				.forEach(a->System.out.println(a));
		
		//Usando Random
		Random random = new Random();
		
		random.ints(1, 49)
		.distinct()
		.limit(6)
		.sorted()
		.forEach(a->System.out.println(a));

		
		//Guardando en colecci�n para luego mostrar m�s f�cil.
		List<Integer> collect = Stream.generate(
				() -> (int)(Math.random()*49+1))
				.distinct()
				.limit(6)
				.sorted()
				.collect(Collectors.toList());
		
		System.out.println("La combinaci�n ganadora es : "+collect);

	}

}
