package com.sicpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sicpa.model.Pedido;

public interface PedidosDao extends JpaRepository<Pedido, Integer> {

}
