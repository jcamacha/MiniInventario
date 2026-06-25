package com.ipn.mx.miniinventario.core.features.categoria.service;

import com.ipn.mx.miniinventario.core.entidades.Categoria;

import java.util.List;

public interface CategoriaService {
    List<Categoria> findAll();
    Categoria findById(Long id);
    Categoria save(Categoria categoria);
    void deleteById(Long id);
}
