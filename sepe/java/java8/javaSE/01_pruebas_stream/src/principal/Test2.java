package principal;

import java.util.List;

public class Test2 {

	public static void main(String[] args) {
		List<Integer> numeros=List.of(10,7,-2,6,4,7,-5,91,14,-11,5,10,-2);
		
		//¿Cuántos números diferentes hay?
		//programación clásica
		int contador=0;
		boolean repetido=false;
		for(int i=0;i<numeros.size();i++) {
			for(int k=0;k<i;k++) {
				if(numeros.get(i)==numeros.get(k)) {
					repetido=true;
					break;
				}
			}
			
			if(!repetido) {
				contador++;
			}
			repetido=false;
		}
		System.out.println(contador);
		
		
		//programación funcional
		System.out.println(numeros.stream()
					.distinct()
					.count());
	}

}
