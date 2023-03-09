package principal;

/**
 * Dado el siguiente array: {8,-4,8,11,34,20,-2} y dada la siguiente variable int a=15.
 * Hacer un programa que calcule la media de todos los números del array, que sean mayores a la variable a
 * @author joseg
 *
 */
public class MediaArrays {

	public static void main(String[] args) {
		
		int[] numeros= {8,-4,8,11,34,20,-2};
		
		int a = 15;
		
		double media = 0;
		
		int totalMayores = 0;
		
//		for (int i = 0; i < numeros.length; i++) {
//		
//			if (numeros[i]>a) {
//			media += numeros[i];
//			totalMayores++;
//			}
//		}
		
		for (int d : numeros) {
			if (d>a) {
				media += d;
				totalMayores++;
				}
		}
		
		media = media / totalMayores;
				
		System.out.println("El total de números mayores de "+a+" es "+totalMayores+" y su media es "+media);
		
	}
}