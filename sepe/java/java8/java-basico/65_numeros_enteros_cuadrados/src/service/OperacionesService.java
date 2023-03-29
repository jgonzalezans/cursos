package service;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class OperacionesService {
	
	public void procesar(List<Integer>numeros,
			UnaryOperator<Integer> transformacion,
			Predicate<Integer> filtro,
			Consumer<Integer> proceso
			) {

		for(Integer num:numeros) {
			if(filtro.test(num)) {
				proceso.accept(transformacion.apply(num));
			}
	}
		
	}

}
