package principal;

/**
 * Solicita la introducci�n de un producto y nos indica cuantas veces aparece
 * ese producto en la lista
 * 
 * @author joseg
 *
 */

public class BuscadorJava11 {

	public static void main(String[] args) {

		String productos = "pelota,pan,agua,pan,vino,pelota,pan,leche,papel,pan,vino";

		String[] productosSplit = productos.split(",");
		
		for (String producto : productosSplit) {

			String[] productoSplit = productos.split(producto);
			int veces = productoSplit.length;
			System.out.println("El producto " + producto + " aparece " + veces + " veces");
		}

	}

}
