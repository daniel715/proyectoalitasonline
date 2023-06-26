package com.daniel.proyectoalitasonline.dto;

public class pedido_producto {
    private String pedidoId;
    private String productoId;
    private String cantidad;

    public String getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(String pedidoId) {
        this.pedidoId = pedidoId;
    }

    public String getProductoId() {
        return productoId;
    }

    public void setProductoId(String productoId) {
        this.productoId = productoId;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
}
