package principal;

/**
 * Este programa calcula el precio de un producto a partir del precio unitario,
 * las unidades y el descuento aplicado
 * @author joseg
 *
 */

public class CalculoFactura {

	public static void main(String[] args) {

		double precio = 4.6;
		int unidades = 7;
		double descuento = 3;
		double total;
		
		total = calcularPrecio(precio,unidades);
		total = aplicarDescuento(total,descuento);

		System.out.println("El precio final con el descuento aplicado es : "+total);
	}
	
	/**
	 * Calcula un precio
	 * @param precio
	 * @param unidades
	 * @return
	 */
	private static double calcularPrecio(double precio, int unidades) {
		return precio * unidades;
	}

	/**
	 * Aplica un descuento
	 * @param precio
	 * @param descuento
	 * @return
	 */
	private static double aplicarDescuento(double precio, double descuento) {
		double descuentoReal = precio * (descuento / 100);
		return precio - descuentoReal;
	}
	
}