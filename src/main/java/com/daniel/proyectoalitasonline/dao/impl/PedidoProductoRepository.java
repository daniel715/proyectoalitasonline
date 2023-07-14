package com.daniel.proyectoalitasonline.dao.impl;


import com.daniel.proyectoalitasonline.dao.IPedidoProductoRepository;
import com.daniel.proyectoalitasonline.dto.PedidoProducto;
import com.daniel.proyectoalitasonline.dto.RespuestaTotalPorPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PedidoProductoRepository implements IPedidoProductoRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PedidoProductoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public PedidoProducto findById(String pedidoId, String productoId) {
        List<PedidoProducto> results = jdbcTemplate.query("call producto_has_pedido_find_by_id(?,?)", this::mapRowToPedidoProducto, pedidoId, productoId);
        return results.size() == 0 ?
                null :
                results.get(0);
    }

    @Override
    public Iterable<PedidoProducto> findAll() {
        return jdbcTemplate.query("call producto_has_pedido_list();", this::mapRowToPedidoProducto);
    }

    @Override
    public Iterable<RespuestaTotalPorPedido> findAllTotalPorPedido() {
        return jdbcTemplate.query("call get_total_pagar_por_pedido()", this::mapRowToRespuestaTotalPorPedido);
    }

    @Override
    public Iterable<PedidoProducto> save(Iterable<PedidoProducto> pedidoProducto) {
        jdbcTemplate.update(
                "call producto_has_pedido_save(?)",
                pedidoProducto
        );
        return pedidoProducto;
    }


    @Override
    public PedidoProducto updatePedidoProducto(String pedidoId, String productoId, PedidoProducto pedidoProducto) {
        PedidoProducto pedidoToSend = this.findById(pedidoId, productoId);
        if (pedidoToSend == null) return null;
        else {
            if (pedidoProducto.getCantidad() != null) {
                pedidoToSend.setCantidad(pedidoProducto.getCantidad());
            }
            String sqlquery = "call producto_has_pedido_update(?,?,?)";
            jdbcTemplate.update(sqlquery,
                    pedidoToSend.getPedidoId(),
                    pedidoToSend.getProductoId(),
                    pedidoToSend.getCantidad()
            );
            return pedidoToSend;
        }
    }

    @Override
    public void delete(String pedidoId, String productoId) {
        String sqlquery = "call producto_has_pedido_delete(?, ?);";
        jdbcTemplate.update(sqlquery, pedidoId, productoId);
    }

    private PedidoProducto mapRowToPedidoProducto(ResultSet row, int rowNum)
            throws SQLException {
        return new PedidoProducto(
                row.getString("producto_id"),
                row.getString("pedido_id"),
                row.getInt("cantidad")
        );
    }

    private RespuestaTotalPorPedido mapRowToRespuestaTotalPorPedido(ResultSet row, int i)
            throws SQLException {
        return new RespuestaTotalPorPedido(
                row.getString("pedido_id"),
                row.getBigDecimal("total_price")
        );
    }
}
