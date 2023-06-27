package com.daniel.proyectoalitasonline.dao;

import com.daniel.proyectoalitasonline.dto.Categoria;
import com.daniel.proyectoalitasonline.dto.Producto;

public interface IProductoRepository {
    Producto findById(String id);

    Iterable<Producto> findAll();

    Producto save(Producto producto);

    Producto updateProducto(String productoId, Producto producto);

    void delete(String productoId);
}
