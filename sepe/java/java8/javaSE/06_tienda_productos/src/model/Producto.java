package model;

public class Producto {
	private String nombre;
	private double precio;
	private int stock;
	private String seccion;

	public Producto(String nombre, double precio, int stock, String seccion) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
		this.seccion = seccion;
	}

	public Producto() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

}
