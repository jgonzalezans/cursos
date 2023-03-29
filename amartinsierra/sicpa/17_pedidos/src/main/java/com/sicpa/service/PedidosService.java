package com.sicpa.service;

import java.util.List;

import com.sicpa.model.Pedido;

public interface PedidosService {
	List<Pedido> pedidos();
	boolean altaPedido(Pedido pedido);
}
