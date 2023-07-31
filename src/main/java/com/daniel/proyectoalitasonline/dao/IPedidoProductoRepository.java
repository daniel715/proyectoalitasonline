package com.daniel.proyectoalitasonline.dao;

import com.daniel.proyectoalitasonline.dto.PedidoProducto;
import com.daniel.proyectoalitasonline.dto.RespuestaTotalPorPedido;

public interface IPedidoProductoRepository {
    PedidoProducto findById(String pedidoId, String productoId);

    Iterable<PedidoProducto> findAll();

    Iterable<RespuestaTotalPorPedido> findAllTotalPorPedido();

    PedidoProducto save(PedidoProducto pedidoProducto);

    PedidoProducto updatePedidoProducto(String pedidoId, String productoId, PedidoProducto pedidoProducto);

    void delete(String pedidoId);
}
