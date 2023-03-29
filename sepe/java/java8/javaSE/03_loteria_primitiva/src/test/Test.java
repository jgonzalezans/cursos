package test;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * REALIZAR UN PROGRAMA QUE SIMULE LA COMBINACIÓN GANADORA DE LA PRIMITIVA.
 * GENERA ALEATORIAMENTE 6 NÚMEROS ALEATORIOS ENTRE 1 Y 49.
 * NO SE PUEDEN REPETIR LOS NÚMEROS
 * Y MOSTRARLOS DE MENOR A MAYOR
 * 
 * @author joseg
 *
 */
public class Test {

	public static void main(String[] args) {

		//FIXME: ES EFICIENTE CREAR UN STREAM "INFINITO" AUNQUE SOLO "VIVA" UN TIEMPO?
		//RESPUESTA: NO ES INFINITO SINO QUE SE VAN EJECUTANDO LAS OPERACIONES INTERMEDIAS EN PARALELO.
		
		
		//Lo más simple con lo que se pedía
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

		
		//Guardando en colección para luego mostrar más fácil.
		List<Integer> collect = Stream.generate(
				() -> (int)(Math.random()*49+1))
				.distinct()
				.limit(6)
				.sorted()
				.collect(Collectors.toList());
		
		System.out.println("La combinación ganadora es : "+collect);

	}

}
