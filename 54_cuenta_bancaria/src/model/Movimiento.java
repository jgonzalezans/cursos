package model;

/**
 * Cada movimiento, se caracteriza por un tipo de operación( "ingreso" o
 * "extracción") y una cantidad.
 * 
 * @author joseg
 *
 */
public class Movimiento {

	String tipo;
	double cantidad;

	public Movimiento(String tipo, double cantidad) {
		super();
		this.tipo = tipo;
		this.cantidad = cantidad;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

}
