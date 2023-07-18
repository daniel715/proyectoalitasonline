package com.daniel.proyectoalitasonline.dao.impl;

import com.daniel.proyectoalitasonline.dao.IProductoRepository;
import com.daniel.proyectoalitasonline.dto.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProductoRepository implements IProductoRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Producto findById(String id) {
        List<Producto> results = jdbcTemplate.query("call Producto_find_by_id(?)", this::mapRowToProducto, id);
        return results.size() == 0 ?
                null :
                results.get(0);
    }

    @Override
    public Iterable<Producto> findAll() {
        return jdbcTemplate.query("call Producto_list();", this::mapRowToProducto);
    }

    @Override
    public Producto save(Producto producto) {
        jdbcTemplate.update(
                "call Producto_save(?,?,?,?,?,?)",
                producto.getProductoId(),
                producto.getNombre(),
                producto.getPrecio(),
                producto.getCategoriaId(),
                producto.getCombo(),
                producto.getStock()
        );
        return producto;
    }

    @Override
    public Producto updateProducto(String productoId, Producto producto) {
        Producto productoToSend = this.findById(productoId);
        if (productoToSend == null) return null;
        else {
            if (productoToSend.getNombre() != null) {
                productoToSend.setNombre(producto.getNombre());
            }
            if (productoToSend.getPrecio() != null) {
                productoToSend.setPrecio(producto.getPrecio());
            }
            if (productoToSend.getCategoriaId() != null) {
                productoToSend.setCategoriaId(producto.getCategoriaId());
            }
            if (productoToSend.getCombo() != null) {
                productoToSend.setCombo(producto.getCombo());
            }
            if (productoToSend.getStock() != null) {
                productoToSend.setStock(producto.getStock());
            }
            String sqlquery = "call Producto_update(?,?,?,?,?,?)";
            jdbcTemplate.update(sqlquery,
                    productoToSend.getProductoId(),
                    productoToSend.getNombre(),
                    productoToSend.getPrecio(),
                    productoToSend.getCategoriaId(),
                    productoToSend.getCombo(),
                    productoToSend.getStock()
            );
            return productoToSend;
        }
    }

    @Override
    public void delete(String productoId) {
        String sqlquery = "call Producto_delete(?);";
        jdbcTemplate.update(sqlquery, productoId);
    }

    private Producto mapRowToProducto(ResultSet row, int i) throws SQLException {
        return new Producto(
                row.getString("producto_id"),
                row.getString("nombre"),
                row.getBigDecimal("precio"),
                row.getString("categoria_id"),
                row.getBoolean("isCombo"),
                row.getInt("stock")
        );
    }
}
