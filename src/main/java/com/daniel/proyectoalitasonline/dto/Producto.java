package com.daniel.proyectoalitasonline.dto;

import java.math.BigDecimal;

public class Producto {
    private String productoId;
    private String nombre;
    private BigDecimal precio;
    private String categoriaId;
    private Boolean isCombo;
    private Integer stock;

    public Producto(String productoId, String nombre, BigDecimal precio, String categoriaId, Boolean isCombo, Integer stock) {
        this.productoId = productoId;
        this.nombre = nombre;
        this.precio = precio;
        this.categoriaId = categoriaId;
        this.isCombo = isCombo;
        this.stock = stock;
    }
    public Producto(){};
    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

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
