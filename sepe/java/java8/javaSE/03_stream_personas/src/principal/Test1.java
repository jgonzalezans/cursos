package principal;

import java.util.List;

public class Test1 {

	public static void main(String[] args) {
		List<String> nombres=List.of("Alberto","Juan","Marta","Elena","Alberto","Marcos","Elena");
		nombres.stream()
		.distinct()
		.forEach(n->System.out.println(n));
		
		System.out.println(nombres.stream()
		.distinct()
		.filter(n->n.toLowerCase().startsWith("a"))
		.count());
		
		nombres.stream()
		.distinct()
		.filter(n->n.length()>5)
		.forEach(n->System.out.println(n));
	}

}
