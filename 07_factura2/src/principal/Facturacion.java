package principal;
/**
 * Calcula la factura de un producto a partir de precio unitario y unidades.
 * El descuento será del 5% si vende mas de 10 unidades y 2% en el resto de los casos.
 * @author joseg
 *
 */

public class Facturacion {

	public static void main(String[] args) {

		double precioUnitario = 3.7;
		int unidades = 4;
		double descuento;
		
		descuento = unidades > 10 ? 5.0 : 2.0; 
	}

}
