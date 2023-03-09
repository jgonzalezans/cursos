package service;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class OperacionesService {

	public void procesarPorCriterio(List<Integer> numeros, Consumer<Integer> procesamiento,
			Predicate<Integer> criterio) {
		for (int num : numeros) {
			if (criterio.test(num)) {
				procesamiento.accept(num);
			}
		}

	}
}
