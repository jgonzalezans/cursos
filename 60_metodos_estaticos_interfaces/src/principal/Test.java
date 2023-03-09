package principal;

import java.util.List;
import java.util.Set;

public class Test {

	public static void main(String[] args) {
		//crear una lista de unos cuantos números
		List<Integer> lista=List.of(8,2,9,11);
		//lista.add(20); //ojo, son inmutables, esto no está permitido
		//lista.set(0, 10);
		Set<String> dias=Set.of("lunes","martes","miercoles","jueves");
		
		
		///
		List<StringBuilder> cads=List.of(new StringBuilder("hola"),new StringBuilder("by"));
		cads.get(0).append(" adios");
		System.out.println(cads.get(0));
	}

}
