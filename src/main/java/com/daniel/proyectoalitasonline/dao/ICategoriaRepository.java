package com.daniel.proyectoalitasonline.dao;

import com.daniel.proyectoalitasonline.dto.Categoria;

public interface ICategoriaRepository {
    Categoria findById(String id);

    Iterable<Categoria> findAll();

    Categoria save(Categoria categoria);

    Categoria updateCategoria(String categoriaId, Categoria categoria);

    void delete(String categoriaId);

    Iterable<Categoria> buscarCategoria(String param);
}
