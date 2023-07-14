package com.daniel.proyectoalitasonline.dto;

import java.math.BigDecimal;

public class RespuestaTotalPorPedido {

    private String  pedidoId;
    private BigDecimal precioTotal;

    public String getPedidoId() {
        return pedidoId;
    }

    public RespuestaTotalPorPedido(String pedidoId, BigDecimal precioTotal) {
        this.pedidoId = pedidoId;
        this.precioTotal = precioTotal;
    }

    public void setPedidoId(String pedidoId) {
        this.pedidoId = pedidoId;
    }

    public BigDecimal getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(BigDecimal precioTotal) {
        this.precioTotal = precioTotal;
    }
}
