package com.daniel.proyectoalitasonline.dto;

import java.math.BigDecimal;
import java.sql.Date;

public class Pedido {
    private String pedidoId;
    private Date fechaPedido;
    private Date fechaEntrega;
    private String direccion;
    private String metodoPago;
    private BigDecimal totalPagar;
    private String observacion;
    private String respuestaPago;
    private String status;
    private String direccionIp;
    private String monto_recibido;

    public String getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(String pedidoId) {
        this.pedidoId = pedidoId;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public BigDecimal getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(BigDecimal totalPagar) {
        this.totalPagar = totalPagar;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getRespuestaPago() {
        return respuestaPago;
    }

    public void setRespuestaPago(String respuestaPago) {
        this.respuestaPago = respuestaPago;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDireccionIp() {
        return direccionIp;
    }

    public void setDireccionIp(String direccionIp) {
        this.direccionIp = direccionIp;
    }

    public String getMonto_recibido() {
        return monto_recibido;
    }

    public void setMonto_recibido(String monto_recibido) {
        this.monto_recibido = monto_recibido;
    }
}
