package net.canos.java8.collections;

import java.util.Arrays;
import java.util.List;


public class Collections_003_Streams_Usage_ENUNCIADO {

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
		 * ENUNCIADO 1. Dado un array quiero el nombre de los que están entre 20-35.
		 */
		
		/* 
		 * ENUNCIADO 2. Dado un array quiero el nombre de los que están entre 20-35 y son Centrocampistas.
		 */
		
		/* 
		 * ENUNCIADO 3. Saber cuántos no delanteros tienen menos de 35 años.
		 */

		/*
		 * ENUNCIADO 4. Saber la edad del centrocampista o delantero más joven.
		 */

		/*
		 * ENUNCIADO 5. Saber la edad del centrocampista Y del delantero más joven.
		 */
	}
}


