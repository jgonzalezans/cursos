package principal;

/**
 * Dado un array 7,-3,11,21,-9,28
 * Mostrar la suma de todos sus números
 * @author joseg
 *
 */
public class SumaArray {

	public static void main(String[] args) {
		
		int[] numeros= {7,-3,11,21,-9,28};
		int suma = 0;
		
		for (int i = 0; i < numeros.length; i++) {
			suma+=numeros[i];
		}
		System.out.println("La suma total del array es : "+suma);
	}

}
