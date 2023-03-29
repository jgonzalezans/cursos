package model;

import java.time.LocalDate;

public class Pedido {
	private int idPedido;
	private String producto;
	private int unidades;
	private LocalDate fecha;
	private String tienda;
	public Pedido(int idPedido, String producto, int unidades, LocalDate fecha, String tienda) {
		super();
		this.idPedido = idPedido;
		this.producto = producto;
		this.unidades = unidades;
		this.fecha = fecha;
		this.tienda = tienda;
	}
	public Pedido() {
		super();
	}
	public int getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public int getUnidades() {
		return unidades;
	}
	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public String getTienda() {
		return tienda;
	}
	public void setTienda(String tienda) {
		this.tienda = tienda;
	}
	
	
}
