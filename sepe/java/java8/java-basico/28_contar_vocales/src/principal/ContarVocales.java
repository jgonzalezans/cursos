package principal;

import java.util.Scanner;

/**
 * Realizar un programa que solicite la introducción de un texto. Después, el
 * programa indicará el total de vocales de ese texto.
 * 
 * @author joseg
 *
 */
public class ContarVocales {

	public static void main(String[] args) {

		String texto;
		int vocales = 0;

		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce un texto: ");
		texto = sc.nextLine();

		for (int i = 0; i < texto.length(); i++) {
			if (esVocal(texto.charAt(i))) {
				vocales++;
			}
		}

		System.out.println("El total de vocales de ' " + texto + " ' es: " + vocales);

		sc.close();
	}

	private static boolean esVocal(char charAt) {
		charAt = Character.toLowerCase(charAt);

		boolean esVocal = false;
		switch (charAt) {
		case 'a':
		case 'e':
		case 'i':
		case 'o':
		case 'u':

			esVocal = true;
			break;

		default:
			break;
		}
		return esVocal;
	}

}
