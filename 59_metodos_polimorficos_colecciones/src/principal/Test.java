package principal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> listaNums=new ArrayList<Integer>();
		listaNums.add(6);listaNums.add(4);listaNums.add(15);
		System.out.println(sumador(listaNums));
		
		HashSet<Integer> conjuntoNums=new HashSet<Integer>();
		//conjuntoNums.add(11);conjuntoNums.add(7);conjuntoNums.add(3);
		Collections.addAll(conjuntoNums, 1,7,3);
		System.out.println(sumador(conjuntoNums));
		
		//segundo método
		List<Integer> numeros=transformar(conjuntoNums);
		for(int num:numeros) {
			System.out.println(num);
		}
	}
	
	
	//Realizar un método que reciba una lista o un conjunto de números enteros 
	//y devuelva la suma de todos los elementos
	static int sumador(Collection<Integer> coleccion) {
		int suma=0;
		for(int n:coleccion) {
			suma+=n;
		}
		return suma;
	}
	
	//Realizar un método que recibe un conjunto de números enteros y devuelve
	//una lista con el contenido de dicho conjunto
	
	static List<Integer> transformar(Set<Integer> datos){
		ArrayList<Integer> lista=new ArrayList<Integer>();
		for(int n:datos) {
			lista.add(n);
		}
		return lista;
	}

}
