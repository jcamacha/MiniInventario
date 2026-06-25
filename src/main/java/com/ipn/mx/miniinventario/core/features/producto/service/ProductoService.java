package com.ipn.mx.miniinventario.core.features.producto.service;
import com.ipn.mx.miniinventario.core.entidades.Producto;
import java.util.List;

public interface ProductoService {
    List<Producto> findAll();
    Producto findById(Long id);
    Producto save(Producto producto);
    void deleteById(Long id);
}
