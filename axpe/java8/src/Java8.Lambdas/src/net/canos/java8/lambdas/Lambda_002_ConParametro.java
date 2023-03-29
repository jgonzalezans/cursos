package net.canos.java8.lambdas;

/**
 * En este ejercicio presentamos lambdas con parámetros 
 * 
 * @author David Canos 
 * Twitter: @Canos
 *
 */
public class Lambda_002_ConParametro {

	public static void main(String[] args) {
		/*
		 * Update 1. Vamos a crear una lamdba con parámetros
		 */
		Foo foo = (String a) -> "Hello world "+a;
		System.out.println(foo.method("David"));
		
		/*
		 * Update 2. Múltiples parámetros
		 */
		FooBar bar = (String name, Integer age) -> "Hello world "+name+", tiene "+age+" años.";
		System.out.println(bar.method("David", 34));
		
	}


	@FunctionalInterface
	public interface Foo {
	    String method(String a);	    
	}
	
	@FunctionalInterface
	public interface FooBar {
	    String method(String name, Integer age);   
	}


}
