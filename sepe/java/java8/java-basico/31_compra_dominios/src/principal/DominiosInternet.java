package principal;

import java.util.Scanner;

/**
 * Realizar un pograma que calcule el precio final de la compra de un dominio.
 * Se solicita al usuario la introducción del dominio que quiere. Todos los
 * dominios tienen un precio base de 20 euros. Pero, si el dominio es ".com", se
 * añade un suplemento del 5%, si es ".org" un descuento del 5%.
 * 
 * @author joseg
 *
 */

public class DominiosInternet {

	public static void main(String[] args) {

		String dominio;
		double precio = 20;
		String extension;

		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce el dominio que quieres comprar: ");
		dominio = sc.nextLine();

		extension = dominio.substring(dominio.lastIndexOf('.'));

		switch (extension) {
		case ".com":
			precio = precio + (precio * (5 / 100.0));
			break;
		case ".org":
			precio = precio - (precio * (5 / 100.0));
			break;
		}

		System.out.println("El precio de tu dominio es: " + precio + " €");
		sc.close();
	}

}
