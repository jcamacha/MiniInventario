package com.ipn.mx.miniinventario.core.features.categoria.service;

import com.ipn.mx.miniinventario.core.entidades.Categoria;
import com.ipn.mx.miniinventario.core.features.categoria.repository.CategoriaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService{
    @Autowired
    private CategoriaDAO categoriaDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Categoria> findAll() {
        return (List<Categoria>) categoriaDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Categoria findById(Long id) {
        return categoriaDAO.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Categoria save(Categoria categoria) {
        return categoriaDAO.save(categoria);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        categoriaDAO.deleteById(id);
    }
}
