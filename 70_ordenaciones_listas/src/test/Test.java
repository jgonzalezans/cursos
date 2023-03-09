package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		
		ArrayList<Integer> lista=new ArrayList<>(List.of(4,1,23,9,15,18,22));
		//lista.forEach(n->System.out.println(n));
		//ordena la lista y muestrala
		Collections.sort(lista);
		lista.forEach(n->System.out.println(n));
		
		System.out.println(lista);
	}

}
