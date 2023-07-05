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
    private String respuestaPagoApp;
    private String status;
    private String direccionIp;
    private BigDecimal montoRecibido;
    private Date fechaSalida;
    public Pedido(){}

    public Pedido(String pedidoId, Date fechaPedido, Date fechaSalida, String direccion, String metodoPago, BigDecimal totalPagar, String observacion, String respuestaPagoApp, String status, String direccionIp, BigDecimal montoRecibido, Date fechaEntrega) {
        this.pedidoId = pedidoId;
        this.fechaPedido = fechaPedido;
        this.fechaSalida = fechaSalida;
        this.direccion = direccion;
        this.metodoPago = metodoPago;
        this.totalPagar = totalPagar;
        this.observacion = observacion;
        this.respuestaPagoApp = respuestaPagoApp;
        this.status = status;
        this.direccionIp = direccionIp;
        this.montoRecibido = montoRecibido;
        this.fechaEntrega = fechaEntrega;
    }

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

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
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

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }
}
