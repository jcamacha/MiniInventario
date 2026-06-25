package com.ipn.mx.miniinventario.core.features.producto.repository;

import com.ipn.mx.miniinventario.core.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoDAO extends JpaRepository<Producto, Long>{
    
}
