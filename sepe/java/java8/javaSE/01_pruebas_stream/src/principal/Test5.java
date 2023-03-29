package principal;

import java.util.List;

public class Test5 {

	public static void main(String[] args) {
		List<String> nombres=List.of("Alberto","Juan","Marta","Elena","Alberto","Marcos","Elena");
		
		//mostrar el número de caracteres de cada nombre
		nombres.stream()
		.map(n->n.length()) //stream de Integer
		.forEach(n->System.out.println(n));
		
		nombres.stream()
		.forEach(s->System.out.println(s.length()));
		
		
		//calcula la suma de las longitudes de todos los textos
		System.out.println(nombres.stream()
		.mapToInt(n->n.length()) //IntStream 
		.sum());

	}

}
