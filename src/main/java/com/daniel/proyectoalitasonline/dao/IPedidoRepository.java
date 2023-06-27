package com.daniel.proyectoalitasonline.dao;

import com.daniel.proyectoalitasonline.dto.Pedido;

public interface IPedidoRepository {
    Pedido findById(String id);

    Iterable<Pedido> findAll();

    Pedido save(Pedido categoria);

    Pedido updatePedido(String pedidoId, Pedido pedido);

    void delete(String pedidoId);
}
