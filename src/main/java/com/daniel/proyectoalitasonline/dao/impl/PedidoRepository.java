package com.daniel.proyectoalitasonline.dao.impl;

import com.daniel.proyectoalitasonline.dao.IPedidoRepository;
import com.daniel.proyectoalitasonline.dto.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PedidoRepository implements IPedidoRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PedidoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public Pedido findById(String id) {
        List<Pedido> results = jdbcTemplate.query("call Pedido_find_by_id(?)", this::mapRowToPedido, id);
        return results.size() == 0 ?
                null :
                results.get(0);
    }

    @Override
    public Iterable<Pedido> findAll() {
        return jdbcTemplate.query("call Pedido_list();", this::mapRowToPedido);
    }

    @Override
    public Pedido save(Pedido pedido) {
        jdbcTemplate.update(
                "call Pedido_save(?,?,?,?,?,?,?,?,?,?,?,?)",
                pedido.getPedidoId(),
                pedido.getFechaPedido(),
                pedido.getFechaEntrega(),
                pedido.getDireccion(),
                pedido.getMetodoPago(),
                pedido.getTotalPagar(),
                pedido.getObservacion(),
                pedido.getRespuestaPagoApp(),
                pedido.getStatus(),
                pedido.getDireccionIp(),
                pedido.getMontoRecibido(),
                pedido.getFechaSalida()
        );
        return pedido;
    }

    @Override
    public Pedido updatePedido(String pedidoId, Pedido pedido) {
        Pedido pedidoToSend = this.findById(pedidoId);
        if (pedidoToSend == null) return null;
        else {
            if (pedido.getFechaPedido() != null) {
                pedidoToSend.setFechaPedido(pedido.getFechaPedido());
            }
            if (pedido.getFechaEntrega() != null) {
                pedidoToSend.setFechaEntrega(pedido.getFechaEntrega());
            }
            if (pedido.getDireccion() != null) {
                pedidoToSend.setDireccion(pedido.getDireccion());
            }
            if (pedido.getMetodoPago() != null) {
                pedidoToSend.setMetodoPago(pedido.getMetodoPago());
            }
            if (pedido.getTotalPagar() != null) {
                pedidoToSend.setTotalPagar(pedido.getTotalPagar());
            }
            if (pedido.getObservacion() != null) {
                pedidoToSend.setObservacion(pedido.getObservacion());
            }
            if (pedido.getRespuestaPagoApp() != null) {
                pedidoToSend.setRespuestaPagoApp(pedido.getRespuestaPagoApp());
            }
            if (pedido.getStatus() != null) {
                pedidoToSend.setStatus(pedido.getStatus());
            }
            if (pedido.getDireccionIp() != null) {
                pedidoToSend.setDireccionIp(pedido.getDireccionIp());
            }
            if (pedido.getMontoRecibido() != null) {
                pedidoToSend.setMontoRecibido(pedido.getMontoRecibido());
            }
            if (pedido.getFechaSalida() != null) {
                pedidoToSend.setFechaSalida(pedido.getFechaSalida());
            }

            String sqlquery = "call Pedido_update(?,?,?,?,?,?,?,?,?,?,?,? )";
            jdbcTemplate.update(sqlquery,
                    pedidoToSend.getPedidoId(),
                    pedidoToSend.getFechaPedido(),
                    pedidoToSend.getFechaEntrega(),
                    pedidoToSend.getDireccion(),
                    pedidoToSend.getMetodoPago(),
                    pedidoToSend.getTotalPagar(),
                    pedidoToSend.getObservacion(),
                    pedidoToSend.getRespuestaPagoApp(),
                    pedidoToSend.getStatus(),
                    pedidoToSend.getDireccionIp(),
                    pedidoToSend.getMontoRecibido(),
                    pedidoToSend.getFechaSalida()
            );
            return pedidoToSend;
        }

    }

    @Override
    public void delete(String pedidoId) {
        String sqlquery = "call Pedido_delete(?);";
        jdbcTemplate.update(sqlquery, pedidoId);
    }

    private Pedido mapRowToPedido(ResultSet row, int rowNum)
            throws SQLException {
        return new Pedido(
                row.getString("pedido_id"),
                row.getString("fecha_pedido"),
                row.getString("fecha_entrega"),
                row.getString("direccion"),
                row.getString("metodo_pago"),
                row.getBigDecimal("total_a_pagar"),
                row.getString("observacion"),
                row.getString("respuesta_pago_app"),
                row.getString("status"),
                row.getString("direccion_ip"),
                row.getBigDecimal("efectivo_recibido"),
                row.getString("fecha_salida")
        );
    }
}
