package net.canos.java8.collections;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Collections_013_Streams_Map_toNumber {

	public static void main(String[] args) {
		
		List<Person> roster = Arrays.asList(
			new Person("Cañizares",48, Position.PORTERO),
			new Person("Sempere",60, Position.PORTERO),
			new Person("Nuno",25, Position.PORTERO),
			new Person("Djukic",48, Position.DEFENSA),
			new Person("Camarasa",69, Position.DEFENSA),
			new Person("Busquets",29, Position.DEFENSA),
			new Person("Guedes",25, Position.CENTROCAMPISTA), 
			new Person("Marcelino",50, Position.CENTROCAMPISTA), 
			new Person("Parejo",35, Position.CENTROCAMPISTA),
			new Person("Lato",20, Position.CENTROCAMPISTA), 
			new Person("Zaza",31, Position.DELANTERO),
			new Person("Mista",50, Position.DELANTERO),
			new Person("Villa",42, Position.DELANTERO),
			new Person("Javier Fernandez", 27, Position.AFICIÓN), 
			new Person("Marco Polo", 88, Position.AFICIÓN), 
			new Person("Agustina de Aragón", 96, Position.AFICIÓN));
		
		/*
		 * UPDATE 1. mapToInt
		 */
		IntStream edadesI = roster.stream()
			.mapToInt(p -> p.getAge());
		System.out.println(edadesI.sum());	
				
		DoubleStream edadesD = roster.stream()
				.mapToDouble(p -> p.getAge());
		System.out.println(edadesD.average());

		LongStream edadesL = roster.stream()
				.mapToLong(p -> p.getAge());
		System.out.println(edadesL.skip(3).average());
		
		/*
		 * UPDATE 2. Sumario summaryStatistics
		 */
		DoubleSummaryStatistics summary = roster.stream()
			.mapToDouble(p -> p.getAge())
			.summaryStatistics();
		System.out.println(summary);
	}

}
