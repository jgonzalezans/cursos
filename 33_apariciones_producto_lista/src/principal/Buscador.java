package principal;

import java.util.Scanner;

/**
 * Solicita la introducción de un producto y nos indica cuantas veces aparece
 * ese producto en la lista
 * 
 * @author joseg
 *
 */

public class Buscador {

	public static void main(String[] args) {

		String productos = "pelota,pan,agua,pan,vino,pelota,pan,leche,papel,pan,vino";
		String[] productosSplit = productos.split(",");
		int veces = 0;

		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce un producto para buscarlo: ");

		String productoIntroducido = sc.nextLine();

		for (String producto : productosSplit) {

			if (producto.equals(productoIntroducido)) {
				veces++;
			}

		}

		System.out.println("El producto " + productoIntroducido + " aparece " + veces + " veces");

		sc.close();

	}

}
