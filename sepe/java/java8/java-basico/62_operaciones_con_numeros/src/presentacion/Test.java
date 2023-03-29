package presentacion;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import service.OperacionesService;

public class Test {

	public static void main(String[] args) {
		//lista cualquiera de números
		List<Integer> nums=List.of(7,-3,5,2,9,-10,4,7);
		OperacionesService service=new OperacionesService();
		System.out.println("La suma de los pares es: "+service.sumaPorCriterio(nums,new Pares()));
		System.out.println("La suma de los positivos es: "+service.sumaPorCriterio(nums, new Positivos()));
		
		
		//imprimir los positivos
		service.procesarPorCriterio(nums, new Imprimir(), new Positivos());
	}

}

class Pares implements Predicate<Integer>{

	@Override
	public boolean test(Integer t) {
		return t%2==0;
	}
	
}

class Positivos implements Predicate<Integer>{

	@Override
	public boolean test(Integer t) {
		return t>=0;
	}
	
}

class Imprimir implements Consumer<Integer>{

	@Override
	public void accept(Integer t) {
		System.out.println(t);
		
	}
	
}
