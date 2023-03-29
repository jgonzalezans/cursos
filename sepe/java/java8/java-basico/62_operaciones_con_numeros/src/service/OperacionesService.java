package service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class OperacionesService {
	/*public int sumaPares(List<Integer> numeros) {
		int suma=0;
		for(int num:numeros) {
			if(num%2==0) {
				suma+=num;
			}
		}
		return suma;
	}
	
	public int sumarPositivos(List<Integer> numeros) {
		int suma=0;
		for(int num:numeros) {
			if(num>=0) {
				suma+=num;
			}
		}
		return suma;
	}*/
	//el método recibe la lista y el criterio o condición que debe cumpliar un número
	//para ser sumado. Recorremos la lista y sumamos aquellos que cumplan el criterio
	//o sea, que la llamada a test sea true
	public int sumaPorCriterio(List<Integer> numeros,Predicate<Integer> criterio) {
		int suma=0;
		for(int num:numeros) {
			if(criterio.test(num)) {
				suma+=num;
			}
		}
		return suma;
	}
	
	
	//procesa los elementos que cumplen criterio
	public void procesarPorCriterio(List<Integer> numeros,
									Consumer<Integer> procesamiento,
									Predicate<Integer> criterio) {
		for(int num:numeros) {
			if(criterio.test(num)) {
				procesamiento.accept(num);
			}
		}
		
	}
	
	
	//transforma los elementos de la lista que cumplen el criterio
	
	public List<Integer> transformarPorCriterio(List<Integer> numeros,
												//Function<Integer,Integer> transformacion,
												UnaryOperator<Integer> transformacion,
												Predicate<Integer> criterio){
		ArrayList<Integer> resultado=new ArrayList<Integer>();
		for(int num:numeros) {
			if(criterio.test(num)) {
				resultado.add(transformacion.apply(num));
			}
		}
		return resultado;
	}
	
	
	
}
