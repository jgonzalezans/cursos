package model;

public class Venta {
	private String producto;
	private double precio;
	private String seccion;
	public Venta(String producto, double precio, String seccion) {
		super();
		this.producto = producto;
		this.precio = precio;
		this.seccion = seccion;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getSeccion() {
		return seccion;
	}
	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}
	
}
