package net.canos.java8.lambdas;

/**
 * Un pequeño ejemplo de un hola mundo desde lambdas, 
 * en este caso ya utilizamos un Interfaz Funcional
 * 
 * @author David Canos 
 * Twitter: @Canos
 *
 */
public class Lambda_001_FunctionalInterface {
	
	public static void main(String[] args) {
		/*
		 * Update 1. Hola Mundo de toda la vida
		 */
		holaMundo();

		/*
		 * Update 2. Guardo la lambda en un objeto.
		 * Foo es realmente una interfaz. 
		 * La implementación de la interfaz es la propia lambda.
		 */
		Foo foo = () -> System.out.println("Hello world en una lambda");
		foo.method(); // lo he llamado method, pero soy libre de usar el nombre que quiera para el método.

		/*
		 * Update 3. La lambda acaba de ser enviada a otro método.
		 * Hemos enviado una función por parámetro!!!
		 */
		llamaloTu(foo);
		
	}

	private static void holaMundo() {
		System.out.println("Hello world en un método");
	}
	
	private static void llamaloTu(Foo foo) {
		foo.method();		
	}

	/**
	 * La anotación no es obligada, pero si muy recomendable.
	 */
	@FunctionalInterface
	public interface Foo {
	    void method();
	    
	    // No puede tener dos métodos
	    //String method2(String a);
	}
}
