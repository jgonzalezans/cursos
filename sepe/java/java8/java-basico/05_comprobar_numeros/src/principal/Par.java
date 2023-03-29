package principal;

/**
 * Dado un número en una variable
 * indicara si es par o no.
 * @author joseg
 *
 */
public class Par {

	public static void main(String[] args) {

		int numero = 7;
		if (numero % 2 == 0) {
			System.out.println("El número " + numero + " es par");
		} else {
			System.out.println("El número " + numero + " es impar");
		}

	}
}