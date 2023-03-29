package principal;

/**
 * Dado el siguiente array: {8,-4,8,11,34,20,-2} y dada la siguiente variable int a=15.
 * Hacer un programa que calcule la media de todos los números del array, que sean mayores a la variable a
 * @author joseg
 *
 */
public class MediaArrays2 {

	public static void main(String[] args) {
		
		double[] numeros= {8,-4,8,11,34,20,-2};
		
		int a = 15;
		
		double [] numerosMayores =  new double[numeros.length];
		
		for (int i = 0; i < numeros.length; i++) {
		
			if (numeros[i]>a) {
			numerosMayores[i] = numeros [i];
			}
		}
		
		System.out.println(""+numerosMayores.toString());
		
	}
}