package principal;

import java.util.List;

public class Test3 {

	public static void main(String[] args) {
		List<Integer> numeros=List.of(10,7,-2,6,4,7,-5,91,14,-11,5,10,-2);
		//sin contar los 7 primeros números de la lista, ¿cuantos números
		//diferentes quedan?
		
		System.out.println(numeros.stream()
			.skip(7)
			.distinct()
			.count());
		
		//sin contar los 7 primeros números de la lista, mostrar los quedan
		//sin repetirlos
		
		numeros.stream()
			.skip(7)
			.distinct()
			.forEach(n->System.out.println(n));
	}

}
