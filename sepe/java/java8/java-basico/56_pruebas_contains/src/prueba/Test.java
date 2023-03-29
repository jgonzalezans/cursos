package prueba;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		ArrayList<Integer> numeros=new ArrayList<Integer>();
		agregar(20,numeros);
		agregar(15,numeros);
		agregar(20,numeros);
		agregar(8,numeros);
		mostrar(numeros);

	}
	
	static void agregar(Integer num, ArrayList<Integer> numeros) {
		if(!numeros.contains(num)) {
			numeros.add(num);
		}
	}
	static void mostrar(ArrayList<Integer> numeros) {
		for(int num:numeros) {
			System.out.println(num);
		}
	}

}
