package service;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class CadenasService {
	
	public void procesarCadenas(List<String>nombres,
			Consumer<Integer> proceso,
			Function<String,Integer> transformacion,
			Predicate<String> condicion
			) {
		
		//recorremos la lista de nombres y procesamos el resultado de tranformar
		//las cadenas que cumplan la condicion
		for(String nombre:nombres) {
			if(condicion.test(nombre)) {
				proceso.accept(transformacion.apply(nombre));
			}
	}
		
	}

}
