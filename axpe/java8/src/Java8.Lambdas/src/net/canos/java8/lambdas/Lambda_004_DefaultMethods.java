package net.canos.java8.lambdas;


/**
 * 
 * @author David Canós
 * Twitter @Canos
 */
public class Lambda_004_DefaultMethods {
	

	public static void main(String[] args) {
		/*
		 * UPDATE 1.
		 */
		FooIface foo = new Foo();
		System.out.println(foo.method("David", 34));
		
		/*
		 * UPDATE 2.
		 */
		FooIfaceV2 foo2 = new FooV2();
		System.out.println(foo2.method("David", "Canós", 34));	
		
	}


	/*
	 * UPDATE 1. Interfaz original (sin apellido) e implementación original
	 */
	/*
	 * Implementación de la interfaz
	 */
	static public class Foo implements FooIface{
		
	    @Override
		public String method(String name, Integer age) {
	    	return "Hello world "+name+", tiene "+age+" años.";
	    }
	}
	
	@FunctionalInterface
	public interface FooIface{
	    public String method(String name, Integer age); 
	}
	
	
	/*
	 * UPDATE 2. En el futuro, queremos añadir una opción más: Añadir el apellido. 
	 * Sin embargo, no podemos cambiar todas las implementaciones de la interfaz FooIface 
	 * que tenemos porque sería mucho trabajo.
	 * 
	 * ¿Cómo podemos hacer que todas nuestras implementaciones tengan la nueva funcionalidad sin necesidad de programarlo en todas las implementaciones?
	 * Añadiendo un método default en la INTERFAZ original
	 */
	static public class FooV2 implements FooIfaceV2{		
	    @Override
		public String method(String name, Integer age) {
	    	return "Hello world "+name+", tiene "+age+" años.";
	    }
	}
	
	@FunctionalInterface
	public interface FooIfaceV2{
	    public String method(String name, Integer age);  
	    
	    default String method(String name, String surname, Integer age) {
	    	return method(name+" "+surname, age);
	    };  
	    
	    default String method2(String name, String surname, Integer age) {
	    	return method(name+" "+surname, age);
	    }; 
	    
	    static String method3(String name, String surname, Integer age) {
	    	return name+" "+surname;
	    };   
	}
    
}