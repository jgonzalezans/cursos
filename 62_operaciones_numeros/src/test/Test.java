package test;

import java.util.List;
import java.util.function.Predicate;

import service.OperacionesService;

public class Test {

	public static void main(String[] args) {
		//lista cualquiera de números
		List<Integer> nums = List.of(7, -3, 5, 2, 9, -10, 4, 7);
		OperacionesService service = new OperacionesService();

	}

}

class Pares implements Predicate<Integer> {

	@Override
	public boolean test(Integer t) {
		return t % 2 == 0;
	}

}

class Positivos implements Predicate<Integer> {

	@Override
	public boolean test(Integer t) {
		return t >= 0;
	}

}