package com.ipn.mx.miniinventario.core.features.producto.service;

import com.ipn.mx.miniinventario.core.entidades.Producto;
import com.ipn.mx.miniinventario.core.features.producto.repository.ProductoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {
    @Autowired
    private ProductoDAO productoDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Producto> findAll(){
        return (List<Producto>) productoDAO.findAll();
    }
    @Override
    @Transactional(readOnly = true)
    public Producto findById(Long id) {
        return productoDAO.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Producto save(Producto producto){
        return productoDAO.save(producto);
    }

    @Override
    @Transactional
    public void deleteById(Long id){
        productoDAO.deleteById(id);
    }
}