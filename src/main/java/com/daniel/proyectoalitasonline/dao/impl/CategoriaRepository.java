package com.daniel.proyectoalitasonline.dao.impl;

import com.daniel.proyectoalitasonline.dao.ICategoriaRepository;
import com.daniel.proyectoalitasonline.dto.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CategoriaRepository implements ICategoriaRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CategoriaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Categoria findById(String id) {
        List<Categoria> results = jdbcTemplate.query("call Categoria_find_by_id(?)", this::mapRowToCategoria, id);
        return results.size() == 0 ?
                null :
                results.get(0);
    }

    @Override
    public Iterable<Categoria> findAll() {
        return jdbcTemplate.query("call Categoria_list();", this::mapRowToCategoria);
    }

    @Override
    public Categoria save(Categoria categoria) {
        jdbcTemplate.update(
                "call Categoria_save(?,?)",
                categoria.getIdCategoria(),
                categoria.getNombre()
        );
        return categoria;
    }

    @Override
    public Categoria updateCategoria(String categoriaId, Categoria categoria) {
        Categoria categoriaToSend = this.findById(categoriaId);
        if (categoriaToSend == null) return null;
        else {
            if (categoria.getNombre() != null) {
                categoriaToSend.setNombre(categoria.getNombre());
            }
            String sqlquery = "call Categoria_update( ?, ?)";
            jdbcTemplate.update(sqlquery,
                    categoriaToSend.getIdCategoria(),
                    categoriaToSend.getNombre()
            );
            return categoriaToSend;
        }

    }

    @Override
    public Iterable<Categoria> buscarCategoria(String param) {
        String sqlquery = "SELECT * FROM librocategorias WHERE nombre LIKE '%" + param + "%'";
        return jdbcTemplate.query(sqlquery, this::mapRowToCategoria);
    }

    @Override
    public void delete(String categoriaId) {
        String sqlquery = "call Categoria_delete(?);";
        jdbcTemplate.update(sqlquery, categoriaId);
    }

    private Categoria mapRowToCategoria(ResultSet row, int rowNum)
            throws SQLException {
        return new Categoria(
                row.getString("id_categoria"),
                row.getString("nombre")
        );
    }
}
