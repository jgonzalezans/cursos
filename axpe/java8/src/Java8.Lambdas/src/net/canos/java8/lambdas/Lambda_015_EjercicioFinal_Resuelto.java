package net.canos.java8.lambdas;

import java.util.Arrays;
import java.util.List;

public class Lambda_015_EjercicioFinal_Resuelto {

	
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
		printPersonsOlderThan(roster, 30);
		
		/* UPDATE 2.
		 * Ahora queremos encontrar jugadores entre una determinada edad y que su nombre comience por una determinada secuencia
		 */
		log("\n\nUPDATE 2");
		printPersonsBetweenAndStartingWith(roster, 30, 65, "Marc");

		/* UPDATE 3. Esto va a crecer mucho 
		 * Mejor estructuramos y creamos un PersonFilter que haga esto
		 */
		log("\n\nUPDATE 3");
		printPersonsOlderThan(roster, new PersonFilter(30, 45, null));

	}

	/**
	 * UPDATE 1.
	 * Implementación clásica
	 */
	public static void printPersonsOlderThan(List<Person> roster, int age) {
	    for (Person p : roster) {
	        if (p.getAge() >= age) {
	            p.print();
	        }
	    }
	}
	
	/**
	 * UPDATE 2. 
	 */
	public static void printPersonsBetweenAndStartingWith(List<Person> roster, int minAge, int maxAge, String partialName) {
	    for (Person p : roster) {
	        if (p.getAge() >= minAge && 
	        		p.getAge() < maxAge && 
	        		p.getName().startsWith(partialName)) {
	            p.print();
	        }
	    }
	}

	/**
	 * UPDATE 3. 
	 */
	public static void printPersonsOlderThan(List<Person> roster, PersonFilter filter) {
	    for (Person p : roster) {
	        if (filter.test(p)) {
	            p.print();
	        }
	    }
	}



	
	private static void log(String string) {
		System.out.println(string);
	}
	
}



