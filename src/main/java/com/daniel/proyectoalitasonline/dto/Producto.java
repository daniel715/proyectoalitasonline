package com.daniel.proyectoalitasonline.dto;

import java.math.BigDecimal;

public class Producto {
    private String productoId;
    private String nombre;
    private BigDecimal precio;
    private String categoriaId;
    private Boolean isCombo;

    public String getProductoId() {
        return productoId;
    }

    public void setProductoId(String productoId) {
        this.productoId = productoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(String categoriaId) {
        this.categoriaId = categoriaId;
    }

    public Boolean getCombo() {
        return isCombo;
    }

    public void setCombo(Boolean combo) {
        isCombo = combo;
    }
}
