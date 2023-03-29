/**
 * Ejercicio. Programa que dados dos números,
 * nos muestre el mayor de los dos.
 * @author joseg
 *
 */
public class NumeroMayor {

	public static void main(String[] args) {

		int numero1 = -5;
		int numero2 = 19;

		if (numero1 > numero2) {
			System.out.println("El numero " + numero1 +" es mayor");
		}
		else if (numero2 > numero1) {
			System.out.println("El numero " + numero2 +" es mayor");
		}
		else {
			System.out.println("Son iguales");}

	}
}