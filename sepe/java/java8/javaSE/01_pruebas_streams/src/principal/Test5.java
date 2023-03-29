package principal;

import java.util.List;


/**
 * MAP: map-> un stream de datos de un tipo tienes que transformarlo en datos de otro tipo.
 * 
 * @author joseg
 *
 */
public class Test5 {

	public static void main(String[] args) {

		List<String> nombres=List.of("Alberto","Juan","Marta","Elena","Alberto","Marcos","Elena");
		
		nombres.stream()
		.map(n->n.length())
		.forEach(s->System.out.println(s));
		
		
	}

}
