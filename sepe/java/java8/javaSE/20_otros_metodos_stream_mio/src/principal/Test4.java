package principal;

import java.util.stream.Stream;

public class Test4 {

	public static void main(String[] args) {
		
		//Imprime numeros pares en 1 unica linea y separados con ","
		
		Stream<Integer> nums=Stream.of(8,3,1,7,11,4,10);
		
		nums.filter(n->n%2==0)
		.forEach(n->System.out.println(n));
		
		
		System.out.println("La suma de los pares es: "+
		nums.filter(n->n%2==0)
		.peek(n->System.out.println(n))
		.mapToInt(n->n)
		.sum());

		
	}

}
