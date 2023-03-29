package principal;

/**
 * Solicita la introducción de un producto y nos indica cuantas veces aparece
 * ese producto en la lista
 * 
 * @author joseg
 *
 */

public class BuscadorRebuscado {

	public static void main(String[] args) {

		String productos = "pelota,pan,agua,pan,vino,pelota,pan,leche,papel,pan,vino";

		String[] productosSplit = productos.split(",");

		String apariciones = "";

		for (String producto : productosSplit) {

			String[] productoSplit = productos.split(producto);
			if(!apariciones.contains(producto))
			apariciones+=producto;
			if (apariciones.contains(producto)) {
				int veces = productoSplit.length - 1;
				System.out.println("El producto " + producto + " aparece " + veces + " veces");
			}
		}

	}

}
