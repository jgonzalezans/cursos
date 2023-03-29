package net.canos.java8.lambdas;

import java.util.Arrays;
import java.util.List;

public class Lambda_015_EjercicioFinal_Enunciado {

	
	/**
	 * 
	 */
	public static void main(String[] args) {
	
		// Esta es nuestra base de datos
		List<Person> roster = Arrays.asList(
				new Person("Guedes",25), 
				new Person("Marcelino",50), 
				new Person("Parejo",35));

		/* UPDATE 1.
		 * El programa debe pintar los jugadores de menos de una determinada edad
		 */
		log("UPDATE 1");
		
		/* UPDATE 2.
		 * Ahora queremos encontrar jugadores entre una determinada edad y que su nombre comience por una determinada secuencia
		 */
		log("\n\nUPDATE 2");
		
		/* UPDATE 3. Esto va a crecer mucho 
		 * Mejor estructuramos y creamos un PersonFilter que haga esto
		 */
		log("\n\nUPDATE 3");
		
	}



	
	private static void log(String string) {
		System.out.println(string);
	}
	
}



