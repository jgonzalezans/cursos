package net.canos.java8.collections;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

	
public class Collections_035_Streams_Parallel_Limit_Threads {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

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
		 * LIMITANDO el NÚMERO DE HILOS
		 */
		ForkJoinPool customThreadPool = new ForkJoinPool(8);
	    customThreadPool.submit(() -> 
		    roster.stream().parallel().map(p -> {				
				log(p.getName());
				return p.getName();
			}).collect(Collectors.toSet())).get();
	    
	}
	
	
	
	
	
	
	
	
	
	
	private static void log(Object o) {
		System.out.println(Thread.currentThread().getName()+" "+o);
	}

}
