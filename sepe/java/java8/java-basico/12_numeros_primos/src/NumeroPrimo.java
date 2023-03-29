/**
 * Realizar un programa que, dado un n�mero, nos indique si se trata de un
 * n�mero primo o no. N�meros primos: s�lo dan resto 0 consigo mismo o con 1
 * 
 * @author joseg
 *
 */
public class NumeroPrimo {

	static int contadorPrimos = 0;
	
	public static void main(String[] args) {

		int numero = 18;
		

		if (esPrimo(numero)) {
			System.out.println("El numero " + numero + " es primo");
		} else {
			System.out.println("El numero " + numero + " no es primo");
		}

		pintarPrimos(numero);
		
		System.out.println("El total de primos es: "+contadorPrimos);
	}

	private static boolean esPrimo(int numero) {

		for (int i = 2; i < numero; i++) {
			if (numero % i == 0) {
				return false;
			}
		}
		contadorPrimos++;
		return true;
	}

	private static void pintarPrimos(int numero) {

		System.out.println("Esto son los n�meros primos que hay hasta el " + numero);
		
		for (int i = 0; i <= numero; i++) {
			if (esPrimo(i)) {
				System.out.println(i);
			}
		}
	}

}