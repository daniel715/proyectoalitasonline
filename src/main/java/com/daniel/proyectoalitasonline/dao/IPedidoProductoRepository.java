package com.daniel.proyectoalitasonline.dao;

import com.daniel.proyectoalitasonline.dto.PedidoProducto;

public interface IPedidoProductoRepository {
    PedidoProducto findById(String pedidoId, String productoId);

    Iterable<PedidoProducto> findAll();

    PedidoProducto save(PedidoProducto pedidoProducto);

    PedidoProducto updatePedidoProducto(String pedidoId, String productoId, PedidoProducto pedidoProducto);

    void delete(String pedidoId, String productoId);
}
