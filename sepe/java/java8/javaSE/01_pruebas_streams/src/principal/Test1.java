package principal;

import java.util.List;

public class Test1 {

	public static void main(String[] args) {

		List<Integer> numeros=List.of(10,7,-2,6,4,7,-5,91,14,-11,5,10,-2);

		numeros.stream().skip(7).distinct().count();
	}

}
