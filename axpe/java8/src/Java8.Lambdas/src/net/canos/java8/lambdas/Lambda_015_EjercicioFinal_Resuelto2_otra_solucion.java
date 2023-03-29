package net.canos.java8.lambdas;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Lambda_015_EjercicioFinal_Resuelto2_otra_solucion {

	
	/**
	 * El programa debe pintar los jugadores de menos de una determinada edad
	 */
	public static void main(String[] args) {
	
		// Esta es nuestra base de datos
		List<Person> roster = Arrays.asList(
				new Person("Guedes",25), 
				new Person("Marcelino",50), 
				new Person("Parejo",35));

		// UPDATE 1.
		log("UPDATE 1");
		printPersonsOlderThan(roster, 30);
		
		// UPDATE 2.
		log("\n\nUPDATE 2");
		printPersonsBetweenAndStartingWith(roster, 30, 65, "Marc");

		// UPDATE 3.
		log("\n\nUPDATE 3");
		printPersonsOlderThan(roster, new PersonFilter(30, 45, null));
		
		// UPDATE 4. Uso de lamba expressions para predicado
		log("\n\nUPDATE 4");
		Predicate<Person> predicate = (Person p) -> {
			return (p.getAge() > 33 && 
					p.getAge() < 45);
		};
		printPersons(roster, predicate);
		
		// UPDATE 5. Lambdas: predicado y consumidor
		log("\n\nUPDATE 5");
		printPersons(roster, predicate, (p) -> p.print());
		
		// UPDATE 6. Lambdas: predicado, conversión y consumidor
		log("\n\nUPDATE 6");
		printPersonName(roster, predicate, 
				(Person p) -> p.getName(), 
				(p) -> System.out.println(p));
		
		// UPDATE 7. Lambdas: predicado, conversión y consumidor de manera genérica
		log("\n\nUPDATE 7");
		printPersonInfoGeneric(roster, predicate, 
				(Person p) -> p.getName(), 
				(p) -> System.out.println(p));
		
		printPersonInfoGeneric(roster, predicate, 
				(Person p) -> p.getAge().toString(), 
				(p) -> System.out.println(p));		
		/*
		 * Ojo, esto es complicado y poco visual, pero es potente.
		 */
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
	 * UPDATE 2. Qué ocurre si el programa aumenta su complejidad y ahora queremos encontrar 
	 * jugadores entre una determinada edad y que su nombre comience por una determinada secuencia
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
	 * UPDATE 3. Esto va a crecer mucho, mejor creamos una clase que haga esto.
	 * PersonFilter 
	 */
	public static void printPersonsOlderThan(List<Person> roster, PersonFilter filter) {
	    for (Person p : roster) {
	        if (filter.test(p)) {
	            p.print();
	        }
	    }
	}

	/**
	 * UPDATE 4. Mediante Lambda
	 * 
	 */
	private static void printPersons(List<Person> roster, Predicate<Person> predicate) {
		for (Person p : roster) {
	        if (predicate.test(p)) {
	            p.print();
	        }
	    }
	}
	
	/**
	 * UPDATE 5. Mediante PRedicado y consumidor
	 */
	private static void printPersons(List<Person> roster, Predicate<Person> predicate, Consumer<Person> action) {
		for (Person p : roster) {
	        if (predicate.test(p)) {
	        	action.accept(p);
	        }
	    }
	}

	/**
	 * UPDATE 6. Mediante Predicado (filtro), 
	 */
	private static void printPersonName(List<Person> roster, Predicate<Person> predicate, Function<Person, String> function, Consumer<String> action) {
		for (Person p : roster) {
	        if (predicate.test(p)) {
	        	String r = function.apply(p);
	        	action.accept(r);
	        }
	    }
	}
	
	/**
	 * UPDATE 7. Mediante Predicado (filtro), 
	 * @param <T>
	 */
	private static <T> void printPersonInfoGeneric(Collection<T> roster, Predicate<T> predicate, Function<T, String> function, Consumer<String> action) {
		for (T p : roster) {
	        if (predicate.test(p)) {
	        	String r = function.apply(p);
	        	action.accept(r);
	        }
	    }
	}
	
	private static void log(String string) {
		System.out.println(string);
	}

}


