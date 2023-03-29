package service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import model.Venta;

public class VentasService {
	HashSet<Venta> ventas=new HashSet<Venta>();
	//EVITAR DOS VENTAS DE UN MISMO PRODUCTO
	public void agregarVenta(String producto, double precio, String seccion) {
		Venta venta=new Venta(producto, precio, seccion);
		//si el producto no está repetido, guarda la venta
		if(!comprobarSiRepetido(producto)) {
			ventas.add(venta);
		}
		
	}
	private boolean comprobarSiRepetido(String producto) {
		for(Venta venta:ventas) {
			if(venta.getProducto().equals(producto)) {
				return true;
			}
		}
		return false;
	}
	public double facturacion() {
		double factura=0;
		for(Venta venta:ventas) {
			factura=factura+venta.getPrecio();
		}
		return factura;
	}
	
	public List<Venta> ordenadorPorPrecio() {
		ArrayList <Venta> listaVentas = new ArrayList<Venta>(ventas);
		listaVentas.sort(
				(a,b)->a.getPrecio()>b.getPrecio()?1:-1
				);
		 return listaVentas;
	}
	
	public List<Venta> ordenadorPorProducto() {
		ArrayList <Venta> listaVentas = new ArrayList<Venta>(ventas);
		listaVentas.sort(
				(a,b)->a.getProducto().compareTo(b.getProducto()));
		 return listaVentas;
	}
}
