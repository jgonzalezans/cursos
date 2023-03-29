package principal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test1 {

	public static void main(String[] args) {
		ArrayList<Integer> lista=new ArrayList<>(List.of(4,1,23,9,15,18,22));
		//lista.forEach(n->System.out.println(n));
		//ordena la lista y muestrala
		//Collections.sort(lista);
		//usando el método sort() de List
		lista.sort((a,b)->a-b);
		lista.forEach(n->System.out.println(n));
	}

}
