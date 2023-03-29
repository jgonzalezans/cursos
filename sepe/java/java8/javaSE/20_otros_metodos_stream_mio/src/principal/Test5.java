package principal;

import java.util.stream.Stream;

public class Test5 {

	public static void main(String[] args) {
		
		//Imprime numeros pares en 1 unica linea y separados con ","
		
		Stream<Integer> nums=Stream.of(8,3,1,7,11,4,10);
		
		nums.reduce((a,b)->a+b)
		.ifPresent(a->System.out.println(a));

		
	}

}
