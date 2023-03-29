package com.sicpa.service;

import java.util.List;

import com.sicpa.model.Producto;

public interface ProductosService {
	List<Producto> productos();
	double precioProducto(int codigoProducto);
	boolean actualizarStock(int codigoProducto, int unidades);
}
