/**
 * Hacer un programa que dados dos números, calcule el total de numeros pares que hay entre ambos
 * @author joseg
 *
 */
public class ParesNumeros {

	public static void main(String[] args) {
		
		int numero1 = 5;
		int numero2 = 12;
	
		int totalPares = 0;

		for (int i = numero1; i <= numero2; i++) {
			
			if(i%2==0) {
				System.out.println("El número " +i+ " es par");
				totalPares++;
			}

		}
		
		System.out.println("Total de nº pares: "+totalPares);
		
	}

}
