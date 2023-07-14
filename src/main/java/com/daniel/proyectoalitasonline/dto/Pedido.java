package com.daniel.proyectoalitasonline.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Pedido {
    private String pedidoId;
    private String fechaPedido;
    private String fechaEntrega;
    private String direccion;
    private String metodoPago;
    private BigDecimal totalPagar;
    private String observacion;
    private String respuestaPagoApp;
    private String status;
    private String direccionIp;
    private BigDecimal montoRecibido;
    private String fechaSalida;

    Pedido(){}

    public Pedido(String pedidoId, String fechaPedido, String fechaEntrega, String direccion, String metodoPago, BigDecimal totalPagar, String observacion, String respuestaPagoApp, String status, String direccionIp, BigDecimal montoRecibido, String fechaSalida) {
        this.pedidoId = pedidoId;
        this.fechaPedido = fechaPedido;
        this.fechaEntrega = fechaEntrega;
        this.direccion = direccion;
        this.metodoPago = metodoPago;
        this.totalPagar = totalPagar;
        this.observacion = observacion;
        this.respuestaPagoApp = respuestaPagoApp;
        this.status = status;
        this.direccionIp = direccionIp;
        this.montoRecibido = montoRecibido;
        this.fechaSalida = fechaSalida;
    }

    public String getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(String pedidoId) {
        this.pedidoId = pedidoId;
    }

    public String getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(String fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
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

    public String getRespuestaPagoApp() {
        return respuestaPagoApp;
    }

    public void setRespuestaPagoApp(String respuestaPagoApp) {
        this.respuestaPagoApp = respuestaPagoApp;
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

    public BigDecimal getMontoRecibido() {
        return montoRecibido;
    }

    public void setMontoRecibido(BigDecimal montoRecibido) {
        this.montoRecibido = montoRecibido;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
}