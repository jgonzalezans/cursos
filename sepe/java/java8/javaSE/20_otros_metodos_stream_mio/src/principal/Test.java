package principal;

import java.util.stream.Stream;

public class Test {

	public static void main(String[] args) {
		
		//Pintar pares y la suma de los pares en 1 sola operación
		
		//Solución metodo peek: igual que foreach sin ser final
		
		Stream<Integer> nums=Stream.of(8,3,1,7,11,4,10);
		System.out.println("La suma de los pares es: "+
		nums.filter(n->n%2==0)
		.peek(n->System.out.println(n))
		.mapToInt(n->n)
		.sum());

		
	}

}
