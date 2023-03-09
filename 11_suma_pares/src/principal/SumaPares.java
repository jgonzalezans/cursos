package principal;

/**
 * Realizar un programa que calcule la suma 
 * de todos los numeros pares comprendidos entre dos dados
 * @author joseg
 *
 */
public class SumaPares {

	public static void main(String[] args) {
		
		int a=3;
		int b=14;
		int suma=0;
		for(int i=a;i<=b;i++) {
			//si el número recorrido es par lo acumulamos en suma
			if(i%2==0) {
				System.out.println("La suma de los pares actual es: "+suma);
				suma+=i;
				System.out.println("La suma de los pares actual es: "+suma);
			}
		}
		System.out.println("La suma de los pares definitiva es: "+suma);

	}

}
