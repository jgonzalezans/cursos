package net.canos.java8.lambdas;

import java.util.stream.Stream;

/**
 * 
 * @author David Canós
 * Twitter @Canos
 */
public class Lambda_005_StaticMethods {
	

	public static void main(String[] args) {
		/*
		 * UPDATE 1.
		 */
		Stream<Integer> stream = Stream.of(1,2,3,4);
		
		/*
		 * UPDATE 2.
		 */	
		FooIfaceV2 foo2; //= new FooV2();			
		foo2 = FooIfaceV2.caps();
		
		String name = foo2.method("David", "Canós", 34);
		System.out.println(name);

		
		/*
		 * update 3. 
		 */			
		String name2 = FooIfaceV2.caps().method("David", 35);
		System.out.println(name2);
		
		
		//FooIfaceV2 foo3 = new FooV2();
		//FooIfaceV2.caps();
	}
	
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
	    
	    static FooIfaceV2 caps() {
	    	return (String name, Integer age) -> name.toUpperCase();
	    };
	}
	
	
	
	
	
	
	
	
}