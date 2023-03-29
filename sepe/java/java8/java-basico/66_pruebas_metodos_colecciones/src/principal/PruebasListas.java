package principal;

import java.util.ArrayList;

public class PruebasListas {

	public static void main(String[] args) {

		//List<Integer> lista = List.of(1, 2, 3, 5);
		
		ArrayList<Integer> lista = new ArrayList<>();
		
		lista.add(1);lista.add(5);lista.add(5);lista.add(7);

		lista.forEach(e -> System.out.println(e));
		
		lista.removeIf(n->n>=7);
		
		lista.forEach(e -> System.out.println(e));
		
		lista.replaceAll(n->n*n);
		
		lista.forEach(e -> System.out.println(e));
	}

}
